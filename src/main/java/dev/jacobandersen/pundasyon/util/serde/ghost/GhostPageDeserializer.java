package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPage;
import dev.jacobandersen.pundasyon.obj.ghost.support.*;

import java.io.IOException;

public class GhostPageDeserializer extends StdDeserializer<GhostPage> {
    public GhostPageDeserializer() {
        super(GhostPage.class);
    }

    @Override
    public GhostPage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        Content content = tree.traverse(p.getCodec()).readValueAs(Content.class);
        Dates dates = tree.traverse(p.getCodec()).readValueAs(Dates.class);
        CodeInjection codeInjection = tree.traverse(p.getCodec()).readValueAs(CodeInjection.class);
        OpenGraph openGraph = tree.traverse(p.getCodec()).readValueAs(OpenGraph.class);
        Twitter twitter = tree.traverse(p.getCodec()).readValueAs(Twitter.class);
        Meta meta = tree.traverse(p.getCodec()).readValueAs(Meta.class);

        return GhostPage.builder()
                .content(content)
                .misc(GhostPage.Misc.builder()
                        .featureImage(tree.get("feature_image").asText(""))
                        .build())
                .dates(dates)
                .codeInjection(codeInjection)
                .openGraph(openGraph)
                .twitter(twitter)
                .meta(meta)
                .build();
    }
}
