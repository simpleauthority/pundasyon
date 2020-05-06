package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostAuthorDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = GhostAuthorDeserializer.class)
public class GhostAuthor {
    private int id;
    private String slug;
    private String name;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("cover_image")
    private String coverImage;
    private String bio;
    private String website;
    private String location;
    private String facebook;
    private String twitter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Builder.Default
    private Integer postCount = null;
    private Meta meta;
}
