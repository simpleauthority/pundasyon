package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.obj.ghost.support.Tags;

import java.io.IOException;
import java.util.List;

public class TagsDeserializer extends StdDeserializer<Tags> {
    public TagsDeserializer() {
        super(Tags.class);
    }

    @Override
    public Tags deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        GhostTag primary = tree.get("primary_tag").traverse(p.getCodec()).readValueAs(GhostTag.class);
        List<GhostTag> all = tree.get("tags").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostTag>>() {
        });

        return Tags.builder()
                .primary(primary)
                .all(all)
                .build();
    }
}
