package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.CodeInjection;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;
import dev.jacobandersen.pundasyon.obj.ghost.support.OpenGraph;
import dev.jacobandersen.pundasyon.obj.ghost.support.Twitter;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostInfoDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = GhostInfoDeserializer.class)
public class GhostInfo {
    private String title;
    private String description;
    private Images images;
    private Social social;
    private String lang;
    private String timezone;
    private String url;
    private Meta meta;
    @JsonProperty("open_graph")
    private OpenGraph openGraph;
    private Twitter twitter;
    @JsonProperty("code_injection")
    private CodeInjection codeInjection;

    @Data
    @Builder
    public static class Images {
        private String logo;
        private String icon;
        @JsonProperty("cover_image")
        private String coverImage;
    }

    @Data
    @Builder
    public static class Social {
        private String facebook;
        private String twitter;
    }
}
