package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.UrlsDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = UrlsDeserializer.class)
public class Urls {
    @JsonProperty("canonical_url")
    private String canonicalUrl;
    private String url;
}
