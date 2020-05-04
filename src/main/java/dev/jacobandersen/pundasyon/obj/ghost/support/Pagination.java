package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.PaginationDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = PaginationDeserializer.class)
public class Pagination {
    private int page;
    private int limit;
    private int pages;
    private int total;
    private int next;
    private int prev;
}
