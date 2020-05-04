package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostPostsWithPaginationDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostPostsWithPaginationDeserializer.class)
public class GhostPostsWithPagination {
    private List<GhostPost> posts;
    private Pagination pagination;
}
