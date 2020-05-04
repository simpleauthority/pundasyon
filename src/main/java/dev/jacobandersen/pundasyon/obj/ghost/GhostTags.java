package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostTagsDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostTagsDeserializer.class)
public class GhostTags {
    private List<GhostTag> tags;
}
