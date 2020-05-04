package dev.jacobandersen.pundasyon.obj.wikipedia.geoimage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WikipediaGeoimageImage {
    private long size;
    private long width;
    private long height;
    private String url;
}
