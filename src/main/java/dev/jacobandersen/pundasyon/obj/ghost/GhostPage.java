package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.*;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostPageDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = GhostPageDeserializer.class)
public class GhostPage {
    private Content content;
    private Misc misc;
    private Dates dates;
    private Urls urls;
    @JsonProperty("code_injection")
    private CodeInjection codeInjection;
    private OpenGraph openGraph;
    private Twitter twitter;
    private Meta meta;

    @Data
    @Builder
    public static class Misc {
        @JsonProperty("feature_image")
        private String featureImage;
    }
}
