package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPage;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPagesWithPagination;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;

import java.io.IOException;
import java.util.List;

public class GhostPagesWithPaginationDeserializer extends StdDeserializer<GhostPagesWithPagination> {
    public GhostPagesWithPaginationDeserializer() {
        super(GhostPagesWithPagination.class);
    }

    @Override
    public GhostPagesWithPagination deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        List<GhostPage> pages = tree.get("pages").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostPage>>() {
        });
        Pagination pagination = tree.get("meta").get("pagination").traverse(p.getCodec()).readValueAs(Pagination.class);

        return GhostPagesWithPagination.builder()
                .pages(pages)
                .pagination(pagination)
                .build();
    }
}
