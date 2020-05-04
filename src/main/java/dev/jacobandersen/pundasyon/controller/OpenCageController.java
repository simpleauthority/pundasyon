package dev.jacobandersen.pundasyon.controller;

import dev.jacobandersen.pundasyon.obj.OpenCageResponse;
import dev.jacobandersen.pundasyon.svc.OpenCageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("geocode")
public class OpenCageController {
    private final OpenCageService openCageService;

    @Autowired
    public OpenCageController(OpenCageService openCageService) {
        this.openCageService = openCageService;
    }

    @GetMapping(value = "{place}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OpenCageResponse getForwardGeocode(@PathVariable("place") String place) {
        return openCageService.getForwardGeocode(place);
    }

    @GetMapping(value = "{lat}/{lon}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OpenCageResponse getReverseGeocode(@PathVariable("lat") float latitude, @PathVariable("lon") float longitude) {
        return openCageService.getReverseGeocode(latitude, longitude);
    }
}
