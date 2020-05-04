package dev.jacobandersen.pundasyon.controller.ghost;

import dev.jacobandersen.pundasyon.obj.ghost.GhostPages;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPagesWithPagination;
import dev.jacobandersen.pundasyon.svc.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cms/page")
public class GhostPageController {
    private final GhostService service;

    @Autowired
    public GhostPageController(GhostService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostPagesWithPagination allPages(@RequestParam(value = "limit", required = false, defaultValue = "10") int limit, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return service.getPages(limit, page);
    }

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostPages pageById(@PathVariable("id") String id) {
        return service.getPageById(id);
    }

    @GetMapping(value = "slug/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostPages pageBySlug(@PathVariable("slug") String slug) {
        return service.getPageBySlug(slug);
    }
}
