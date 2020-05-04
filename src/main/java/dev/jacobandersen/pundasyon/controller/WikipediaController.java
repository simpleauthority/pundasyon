package dev.jacobandersen.pundasyon.controller;

import dev.jacobandersen.pundasyon.obj.wikipedia.geoimage.WikipediaGeoimageResponse;
import dev.jacobandersen.pundasyon.svc.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wikipedia")
public class WikipediaController {
    private final WikipediaService wikipediaService;

    @Autowired
    public WikipediaController(WikipediaService wikipediaService) {
        this.wikipediaService = wikipediaService;
    }

    @GetMapping(value = "geoimage/{lat}/{lon}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WikipediaGeoimageResponse getGeoimage(@PathVariable("lat") float latitude, @PathVariable("lon") float longitude) {
        return wikipediaService.getGeoimage(latitude, longitude);
    }
}
