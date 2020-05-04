package dev.jacobandersen.pundasyon.obj.ghost;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.obj.ghost.support.*;
import dev.jacobandersen.pundasyon.util.serde.ghost.GhostPostDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(using = GhostPostDeserializer.class)
public class GhostPost {
    private Author author;
    private Content content;
    private Misc misc;
    private Dates dates;
    private Urls urls;
    @JsonProperty("code_injection")
    private CodeInjection codeInjection;
    @JsonProperty("open_graph")
    private OpenGraph openGraph;
    private Twitter twitter;
    private Meta meta;

    @Data
    @Builder
    public static class Author {
        private GhostAuthor primary;
        private List<GhostAuthor> all;
    }

    @Data
    @Builder
    public static class Misc {
        @JsonProperty("feature_image")
        private String featureImage;
        @JsonProperty("reading_time")
        private int readingTime;
    }
}
