package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.OpenWeatherMapClient;
import dev.jacobandersen.pundasyon.obj.openweathermap.OpenWeatherMapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"openWeatherMap"})
public class OpenWeatherMapService {
    private final OpenWeatherMapClient client;

    @Autowired
    public OpenWeatherMapService(OpenWeatherMapClient client) {
        this.client = client;
    }

    public OpenWeatherMapResponse getWeather(float latitude, float longitude, OpenWeatherMapClient.OpenWeatherMapUnits units) {
        return client.getWeather(latitude, longitude, units).getBody();
    }
}
