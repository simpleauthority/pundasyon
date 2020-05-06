package dev.jacobandersen.pundasyon.controller.ghost;

import dev.jacobandersen.pundasyon.obj.ghost.GhostTag;
import dev.jacobandersen.pundasyon.obj.ghost.GhostTagsWithPagination;
import dev.jacobandersen.pundasyon.svc.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cms/tag")
public class GhostTagController {
    private final GhostService service;

    @Autowired
    public GhostTagController(GhostService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostTagsWithPagination allTags(@RequestParam(value = "limit", required = false, defaultValue = "10") int limit, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return service.getTags(limit, page);
    }

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostTag tagById(@PathVariable("id") String id) {
        return service.getTagById(id);
    }

    @GetMapping(value = "slug/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostTag tagBySlug(@PathVariable("slug") String slug) {
        return service.getTagBySlug(slug);
    }
}
