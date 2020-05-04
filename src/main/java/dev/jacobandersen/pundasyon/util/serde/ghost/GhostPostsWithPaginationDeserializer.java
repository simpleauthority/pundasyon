package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPost;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPostsWithPagination;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;

import java.io.IOException;
import java.util.List;

public class GhostPostsWithPaginationDeserializer extends StdDeserializer<GhostPostsWithPagination> {
    public GhostPostsWithPaginationDeserializer() {
        super(GhostPostsWithPagination.class);
    }

    @Override
    public GhostPostsWithPagination deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        List<GhostPost> posts = tree.get("posts").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostPost>>() {
        });
        Pagination pagination = tree.get("meta").get("pagination").traverse(p.getCodec()).readValueAs(Pagination.class);

        return GhostPostsWithPagination.builder()
                .posts(posts)
                .pagination(pagination)
                .build();
    }
}
