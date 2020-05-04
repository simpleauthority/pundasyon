package dev.jacobandersen.pundasyon.controller;

import dev.jacobandersen.pundasyon.net.OpenWeatherMapClient;
import dev.jacobandersen.pundasyon.obj.openweathermap.OpenWeatherMapResponse;
import dev.jacobandersen.pundasyon.svc.OpenWeatherMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weather")
public class OpenWeatherMapController {
    private final OpenWeatherMapService openWeatherMapService;

    @Autowired
    public OpenWeatherMapController(OpenWeatherMapService openWeatherMapService) {
        this.openWeatherMapService = openWeatherMapService;
    }

    @GetMapping(value = "{lat}/{lon}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OpenWeatherMapResponse getWeather(@PathVariable("lat") float latitude, @PathVariable("lon") float longitude, @RequestParam(value = "units", required = false) OpenWeatherMapClient.OpenWeatherMapUnits units) {
        return openWeatherMapService.getWeather(
                latitude,
                longitude,
                units == null ? OpenWeatherMapClient.OpenWeatherMapUnits.STANDARD : units
        );
    }
}
