package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthor;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthors;

import java.io.IOException;
import java.util.List;

public class GhostAuthorsDeserializer extends StdDeserializer<GhostAuthors> {
    public GhostAuthorsDeserializer() {
        super(GhostAuthors.class);
    }

    @Override
    public GhostAuthors deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return GhostAuthors.builder()
                .authors(p.readValueAsTree().get("authors").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostAuthor>>() {
                }))
                .build();
    }
}
