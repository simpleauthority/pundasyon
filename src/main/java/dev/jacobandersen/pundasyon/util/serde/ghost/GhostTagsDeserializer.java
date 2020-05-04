package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTags;

import java.io.IOException;
import java.util.List;

public class GhostTagsDeserializer extends StdDeserializer<GhostTags> {
    public GhostTagsDeserializer() {
        super(GhostTags.class);
    }

    @Override
    public GhostTags deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return GhostTags.builder()
                .tags(p.readValueAsTree().get("tags").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostTag>>() {
                }))
                .build();
    }
}
