package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostPagesWithPaginationDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostPagesWithPaginationDeserializer.class)
public class GhostPagesWithPagination {
    private List<GhostPage> pages;
    private Pagination pagination;
}
