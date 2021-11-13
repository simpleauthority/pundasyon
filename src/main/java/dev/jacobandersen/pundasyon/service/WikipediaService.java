package dev.jacobandersen.pundasyon.service;

import dev.jacobandersen.pundasyon.net.upstream.WikipediaClient;
import dev.jacobandersen.pundasyon.object.wikipedia.geoimage.WikipediaGeoimageResponse;
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
