package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.OpenCageClient;
import dev.jacobandersen.pundasyon.obj.OpenCageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"opencage"})
public class OpenCageService {
    private final OpenCageClient client;

    @Autowired
    public OpenCageService(OpenCageClient client) {
        this.client = client;
    }

    @Cacheable
    public OpenCageResponse getForwardGeocode(String place) {
        return client.getForwardGeocode(place).getBody();
    }

    @Cacheable
    public OpenCageResponse getReverseGeocode(float latitude, float longitude) {
        return client.getReverseGeocode(latitude, longitude).getBody();
    }
}
