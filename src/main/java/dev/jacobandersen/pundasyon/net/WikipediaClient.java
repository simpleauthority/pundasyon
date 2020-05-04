package dev.jacobandersen.pundasyon.net;

import dev.jacobandersen.pundasyon.obj.wikipedia.geoimage.WikipediaGeoimageResponse;
import dev.jacobandersen.pundasyon.util.MapUtil;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WikipediaClient extends BasicHttpClient {
    public WikipediaClient(@Value("${api.wikipedia.url}") String url) {
        super(url, null);
    }

    public final HttpResponse<WikipediaGeoimageResponse> getGeoimage(float latitude, float longitude) {
        return get(
                WikipediaGeoimageResponse.class,
                MapUtil.createMap(
                        "format", "json",
                        "action", "query",
                        "generator", "geosearch",
                        "ggsprimary", "all",
                        "ggsnamespace", "6",
                        "ggsradius", "10000",
                        "ggscoord", String.format("%s|%s", latitude, longitude),
                        "prop", "imageinfo",
                        "iiprop", "url|size",
                        "iilimit", "5"
                ),
                null
        );
    }
}
