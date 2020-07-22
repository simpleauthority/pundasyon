package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.GhostClient;
import dev.jacobandersen.pundasyon.obj.ghost.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public GhostPost getPostById(String id) {
        return client.getPostById(id).getBody().getPosts().get(0);
    }

    @Cacheable
    public GhostPost getPostBySlug(String slug) {
        return client.getPostBySlug(slug).getBody().getPosts().get(0);
    }

    @Cacheable
    public GhostPostsWithPagination getPostsWithTags(List<String> tags) {
        return client.getPostsWithTags(tags).getBody();
    }

    @Cacheable
    public GhostPagesWithPagination getPages(int limit, int page) {
        return client.getPages(limit, page).getBody();
    }

    @Cacheable
    public GhostPage getPageById(String id) {
        return client.getPageById(id).getBody().getPages().get(0);
    }

    @Cacheable
    public GhostPage getPageBySlug(String slug) {
        return client.getPageBySlug(slug).getBody().getPages().get(0);
    }

    @Cacheable
    public GhostPagesWithPagination getPagesWithTags(List<String> tags) {
        return client.getPagesWithTags(tags).getBody();
    }

    @Cacheable
    public GhostTagsWithPagination getTags(int limit, int page) {
        return client.getTags(limit, page).getBody();
    }

    @Cacheable
    public GhostTag getTagById(String id) {
        return client.getTagById(id).getBody().getTags().get(0);
    }

    @Cacheable
    public GhostTag getTagBySlug(String slug) {
        return client.getTagBySlug(slug).getBody().getTags().get(0);
    }

    @Cacheable
    public GhostAuthorsWithPagination getAuthors(int limit, int page) {
        return client.getAuthors(limit, page).getBody();
    }

    @Cacheable
    public GhostAuthor getAuthorById(String id) {
        return client.getAuthorById(id).getBody().getAuthors().get(0);
    }

    @Cacheable
    public GhostAuthor getAuthorBySlug(String slug) {
        return client.getAuthorBySlug(slug).getBody().getAuthors().get(0);
    }

    @Cacheable
    public GhostInfo getInfo() {
        return client.getInfo().getBody();
    }
}
