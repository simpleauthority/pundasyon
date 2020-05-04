package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthor;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthorsWithPagination;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;

import java.io.IOException;
import java.util.List;

public class GhostAuthorsWithPaginationDeserializer extends StdDeserializer<GhostAuthorsWithPagination> {
    public GhostAuthorsWithPaginationDeserializer() {
        super(GhostAuthorsWithPagination.class);
    }

    @Override
    public GhostAuthorsWithPagination deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        List<GhostAuthor> authors = tree.get("authors").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostAuthor>>() {
        });
        Pagination pagination = tree.get("meta").get("pagination").traverse(p.getCodec()).readValueAs(Pagination.class);

        return GhostAuthorsWithPagination.builder()
                .authors(authors)
                .pagination(pagination)
                .build();
    }
}
