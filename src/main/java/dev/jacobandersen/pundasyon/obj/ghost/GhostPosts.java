package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostPostsDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostPostsDeserializer.class)
public class GhostPosts {
    private List<GhostPost> posts;
}
