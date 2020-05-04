package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostAuthorsWithPaginationDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostAuthorsWithPaginationDeserializer.class)
public class GhostAuthorsWithPagination {
    private List<GhostAuthor> authors;
    private Pagination pagination;
}
