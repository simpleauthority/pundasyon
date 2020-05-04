package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPage;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPages;

import java.io.IOException;
import java.util.List;

public class GhostPagesDeserializer extends StdDeserializer<GhostPages> {
    public GhostPagesDeserializer() {
        super(GhostPages.class);
    }

    @Override
    public GhostPages deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return GhostPages.builder()
                .pages(p.readValueAsTree().get("pages").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostPage>>() {
                }))
                .build();
    }
}
