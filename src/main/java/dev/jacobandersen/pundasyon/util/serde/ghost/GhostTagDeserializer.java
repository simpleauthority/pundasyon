package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;
import dev.jacobandersen.pundasyon.util.ConditionalUtil;

import java.io.IOException;

public class GhostTagDeserializer extends StdDeserializer<GhostTag> {
    public GhostTagDeserializer() {
        super(GhostTag.class);
    }

    @Override
    public GhostTag deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();
        Meta meta = tree.traverse(p.getCodec()).readValueAs(Meta.class);

        GhostTag.GhostTagBuilder tag = GhostTag.builder()
                .id(tree.get("id").asText(""))
                .name(tree.get("name").asText(""))
                .slug(tree.get("slug").asText(""))
                .description(tree.get("description").asText(""))
                .featureImage(tree.get("feature_image").asText(""))
                .visibility(tree.get("visibility").asText(""))
                .meta(meta);

        if (ConditionalUtil.hasJsonStructure(tree, "count", "count.posts")) {
            tag = tag.postCount(tree.get("count").get("posts").asInt(-1));
        }

        return tag.build();
    }
}
