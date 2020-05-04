package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTagsWithPagination;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;

import java.io.IOException;
import java.util.List;

public class GhostTagsWithPaginationDeserializer extends StdDeserializer<GhostTagsWithPagination> {
    public GhostTagsWithPaginationDeserializer() {
        super(GhostTagsWithPagination.class);
    }

    @Override
    public GhostTagsWithPagination deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        List<GhostTag> tags = tree.get("tags").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostTag>>() {
        });
        Pagination pagination = tree.get("meta").get("pagination").traverse(p.getCodec()).readValueAs(Pagination.class);

        return GhostTagsWithPagination.builder()
                .tags(tags)
                .pagination(pagination)
                .build();
    }
}
