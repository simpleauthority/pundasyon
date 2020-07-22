package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.WikipediaClient;
import dev.jacobandersen.pundasyon.obj.wikipedia.geoimage.WikipediaGeoimageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"wikipedia"})
public class WikipediaService {
    private final WikipediaClient client;

    @Autowired
    public WikipediaService(WikipediaClient client) {
        this.client = client;
    }

    @Cacheable
    public WikipediaGeoimageResponse getGeoimage(float latitude, float longitude) {
        return client.getGeoimage(latitude, longitude).getBody();
    }
}
