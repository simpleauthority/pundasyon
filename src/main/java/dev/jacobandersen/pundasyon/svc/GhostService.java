package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.GhostClient;
import dev.jacobandersen.pundasyon.obj.ghost.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GhostService {
    private final GhostClient client;

    @Autowired
    public GhostService(GhostClient client) {
        this.client = client;
    }

    public GhostPostsWithPagination getPosts(int limit, int page) {
        return client.getPosts(limit, page).getBody();
    }

    public GhostPost getPostById(String id) {
        return client.getPostById(id).getBody().getPosts().get(0);
    }

    public GhostPost getPostBySlug(String slug) {
        return client.getPostBySlug(slug).getBody().getPosts().get(0);
    }

    public GhostPostsWithPagination getPostsWithTags(List<String> tags) {
        return client.getPostsWithTags(tags).getBody();
    }

    public GhostPagesWithPagination getPages(int limit, int page) {
        return client.getPages(limit, page).getBody();
    }

    public GhostPage getPageById(String id) {
        return client.getPageById(id).getBody().getPages().get(0);
    }

    public GhostPage getPageBySlug(String slug) {
        return client.getPageBySlug(slug).getBody().getPages().get(0);
    }

    public GhostPagesWithPagination getPagesWithTags(List<String> tags) {
        return client.getPagesWithTags(tags).getBody();
    }

    public GhostTagsWithPagination getTags(int limit, int page) {
        return client.getTags(limit, page).getBody();
    }

    public GhostTag getTagById(String id) {
        return client.getTagById(id).getBody().getTags().get(0);
    }

    public GhostTag getTagBySlug(String slug) {
        return client.getTagBySlug(slug).getBody().getTags().get(0);
    }

    public GhostAuthorsWithPagination getAuthors(int limit, int page) {
        return client.getAuthors(limit, page).getBody();
    }

    public GhostAuthor getAuthorById(String id) {
        return client.getAuthorById(id).getBody().getAuthors().get(0);
    }

    public GhostAuthor getAuthorBySlug(String slug) {
        return client.getAuthorBySlug(slug).getBody().getAuthors().get(0);
    }

    public GhostInfo getInfo() {
        return client.getInfo().getBody();
    }
}
