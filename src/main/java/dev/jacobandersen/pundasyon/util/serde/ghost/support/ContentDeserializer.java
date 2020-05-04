package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.Content;
import dev.jacobandersen.pundasyon.obj.ghost.support.Tags;

import java.io.IOException;

public class ContentDeserializer extends StdDeserializer<Content> {
    public ContentDeserializer() {
        super(Content.class);
    }

    @Override
    public Content deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();
        Tags tags = tree.traverse(p.getCodec()).readValueAs(Tags.class);

        return Content.builder()
                .id(tree.get("id").asText(""))
                .title(tree.get("title").asText(""))
                .slug(tree.get("slug").asText(""))
                .featured(tree.get("featured").asBoolean(false))
                .html(tree.get("html").asText(""))
                .excerpt(tree.get("excerpt").asText(""))
                .customExcerpt(tree.get("custom_excerpt").asText(""))
                .tags(tags)
                .build();
    }
}
