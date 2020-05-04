package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostTagDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = GhostTagDeserializer.class)
public class GhostTag {
    private String id;
    private String name;
    private String slug;
    private String description;
    @JsonProperty("feature_image")
    private String featureImage;
    private String visibility;
    private String url;
    private Meta meta;
}
