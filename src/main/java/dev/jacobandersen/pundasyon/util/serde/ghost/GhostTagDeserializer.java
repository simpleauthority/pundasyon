package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;

import java.io.IOException;

public class GhostTagDeserializer extends StdDeserializer<GhostTag> {
    public GhostTagDeserializer() {
        super(GhostTag.class);
    }

    @Override
    public GhostTag deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();
        Meta meta = tree.traverse(p.getCodec()).readValueAs(Meta.class);

        return GhostTag.builder()
                .id(tree.get("id").asText(""))
                .name(tree.get("name").asText(""))
                .slug(tree.get("slug").asText(""))
                .description(tree.get("description").asText(""))
                .featureImage(tree.get("feature_image").asText(""))
                .visibility(tree.get("visibility").asText(""))
                .url(tree.get("url").asText(""))
                .meta(meta)
                .build();
    }
}
