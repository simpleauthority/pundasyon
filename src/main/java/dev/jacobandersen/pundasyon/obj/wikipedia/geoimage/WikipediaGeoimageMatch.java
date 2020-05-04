package dev.jacobandersen.pundasyon.obj.wikipedia.geoimage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WikipediaGeoimageMatch {
    private long pageId;
    private String pageTitle;
    private WikipediaGeoimageImage image;
}
