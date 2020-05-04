package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostPagesDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostPagesDeserializer.class)
public class GhostPages {
    private List<GhostPage> pages;
}
