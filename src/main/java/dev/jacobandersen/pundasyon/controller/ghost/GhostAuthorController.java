package dev.jacobandersen.pundasyon.controller.ghost;

import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthors;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthorsWithPagination;
import dev.jacobandersen.pundasyon.svc.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cms/author")
public class GhostAuthorController {
    private final GhostService service;

    @Autowired
    public GhostAuthorController(GhostService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostAuthorsWithPagination allAuthors(@RequestParam(value = "limit", required = false, defaultValue = "10") int limit, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return service.getAuthors(limit, page);
    }

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostAuthors authorById(@PathVariable("id") String id) {
        return service.getAuthorById(id);
    }

    @GetMapping(value = "slug/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostAuthors authorBySlug(@PathVariable("slug") String slug) {
        return service.getAuthorBySlug(slug);
    }
}
