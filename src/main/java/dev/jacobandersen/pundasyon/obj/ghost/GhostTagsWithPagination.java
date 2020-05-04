package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostTagsWithPaginationDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostTagsWithPaginationDeserializer.class)
public class GhostTagsWithPagination {
    private List<GhostTag> tags;
    private Pagination pagination;
}
