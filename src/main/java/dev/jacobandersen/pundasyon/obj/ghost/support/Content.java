package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.ContentDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = ContentDeserializer.class)
public class Content {
    private String id;
    private String title;
    private String slug;
    private boolean featured;
    private String html;
    private String excerpt;
    @JsonProperty("custom_excerpt")
    private String customExcerpt;
    private Tags tags;
}
