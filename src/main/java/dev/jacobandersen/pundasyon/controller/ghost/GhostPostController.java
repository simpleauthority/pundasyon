package dev.jacobandersen.pundasyon.controller.ghost;

import dev.jacobandersen.pundasyon.obj.ghost.GhostPosts;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPostsWithPagination;
import dev.jacobandersen.pundasyon.svc.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cms/post")
public class GhostPostController {
    private final GhostService service;

    @Autowired
    public GhostPostController(GhostService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostPostsWithPagination allPosts(@RequestParam(value = "limit", required = false, defaultValue = "10") int limit, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        return service.getPosts(limit, page);
    }

    @GetMapping(value = "id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostPosts postById(@PathVariable("id") String id) {
        return service.getPostById(id);
    }

    @GetMapping(value = "slug/{slug}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostPosts postBySlug(@PathVariable("slug") String slug) {
        return service.getPostBySlug(slug);
    }
}
