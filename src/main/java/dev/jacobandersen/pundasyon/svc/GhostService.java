package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.GhostClient;
import dev.jacobandersen.pundasyon.obj.ghost.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"ghost"})
public class GhostService {
    private final GhostClient client;

    @Autowired
    public GhostService(GhostClient client) {
        this.client = client;
    }

    @Cacheable
    public GhostPostsWithPagination getPosts(int limit, int page) {
        return client.getPosts(limit, page).getBody();
    }

    @Cacheable
    public GhostPosts getPostById(String id) {
        return client.getPostById(id).getBody();
    }

    @Cacheable
    public GhostPosts getPostBySlug(String slug) {
        return client.getPostBySlug(slug).getBody();
    }

    @Cacheable
    public GhostPagesWithPagination getPages(int limit, int page) {
        return client.getPages(limit, page).getBody();
    }

    @Cacheable
    public GhostPages getPageById(String id) {
        return client.getPageById(id).getBody();
    }

    @Cacheable
    public GhostPages getPageBySlug(String slug) {
        return client.getPageBySlug(slug).getBody();
    }

    @Cacheable
    public GhostTagsWithPagination getTags(int limit, int page) {
        return client.getTags(limit, page).getBody();
    }

    @Cacheable
    public GhostTags getTagById(String id) {
        return client.getTagById(id).getBody();
    }

    @Cacheable
    public GhostTags getTagBySlug(String slug) {
        return client.getTagBySlug(slug).getBody();
    }

    @Cacheable
    public GhostAuthorsWithPagination getAuthors(int limit, int page) {
        return client.getAuthors(limit, page).getBody();
    }

    @Cacheable
    public GhostAuthors getAuthorById(String id) {
        return client.getAuthorById(id).getBody();
    }

    @Cacheable
    public GhostAuthors getAuthorBySlug(String slug) {
        return client.getAuthorBySlug(slug).getBody();
    }

    @Cacheable
    public GhostInfo getInfo() {
        return client.getInfo().getBody();
    }
}
