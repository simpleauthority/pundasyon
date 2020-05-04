package dev.jacobandersen.pundasyon.util.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.wikipedia.geoimage.WikipediaGeoimageImage;
import dev.jacobandersen.pundasyon.obj.wikipedia.geoimage.WikipediaGeoimageMatch;
import dev.jacobandersen.pundasyon.obj.wikipedia.geoimage.WikipediaGeoimageResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WikipediaGeoimageResponseDeserializer extends StdDeserializer<WikipediaGeoimageResponse> {
    public WikipediaGeoimageResponseDeserializer() {
        super(WikipediaGeoimageResponse.class);
    }

    @Override
    public WikipediaGeoimageResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        JsonNode pagesNode = node.get("query").get("pages");
        if (pagesNode == null) {
            return null;
        }

        List<WikipediaGeoimageMatch> pages = new ArrayList<>();
        pagesNode.elements().forEachRemaining(page -> pages.add(pageNodeToPojo(page)));

        return new WikipediaGeoimageResponse(pages);
    }

    private WikipediaGeoimageMatch pageNodeToPojo(JsonNode node) {
        JsonNode imageInfo = node.get("imageinfo").get(0);

        return WikipediaGeoimageMatch.builder()
                .pageId(node.get("pageid").longValue())
                .pageTitle(node.get("title").asText())
                .image(
                        WikipediaGeoimageImage.builder()
                                .size(imageInfo.get("size").longValue())
                                .width(imageInfo.get("width").longValue())
                                .height(imageInfo.get("height").longValue())
                                .url(imageInfo.get("url").asText())
                                .build()
                )
                .build();
    }
}
