package dev.jacobandersen.pundasyon.service;

import dev.jacobandersen.pundasyon.net.upstream.OpenWeatherMapClient;
import dev.jacobandersen.pundasyon.object.openweathermap.OpenWeatherMapResponse;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"openweathermap"})
public class OpenWeatherMapService {
    private final OpenWeatherMapClient client;

    @Autowired
    public OpenWeatherMapService(OpenWeatherMapClient client) {
        this.client = client;
    }

    @Cacheable
    public OpenWeatherMapResponse getWeather(float latitude, float longitude, OpenWeatherMapClient.OpenWeatherMapUnits units) {
        HttpResponse<OpenWeatherMapResponse> resp = client.getWeather(latitude, longitude, units);
        resp.getParsingError().ifPresent(err -> {
            err.printStackTrace();
            System.out.println(err.getOriginalBody());
        });
        return resp.getBody();
    }
}
