package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.TagsDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = TagsDeserializer.class)
public class Tags {
    private GhostTag primary;
    private List<GhostTag> all;
}
