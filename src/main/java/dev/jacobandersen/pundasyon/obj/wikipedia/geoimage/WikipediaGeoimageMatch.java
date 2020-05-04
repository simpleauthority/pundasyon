package dev.jacobandersen.pundasyon.obj.wikipedia.geoimage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WikipediaGeoimageMatch {
    @JsonProperty("page_id")
    private long pageId;
    @JsonProperty("page_title")
    private String pageTitle;
    private WikipediaGeoimageImage image;
}
