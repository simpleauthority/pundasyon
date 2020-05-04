package dev.jacobandersen.pundasyon.net;

import dev.jacobandersen.pundasyon.obj.ghost.*;
import dev.jacobandersen.pundasyon.util.MapUtil;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GhostClient extends BasicHttpClient {
    public GhostClient(@Value("${api.ghost.url}") String url, @Value("${api.ghost.key}") String key) {
        super(url, MapUtil.createMap("key", key));
    }

    public HttpResponse<GhostPostsWithPagination> getPosts(int limit, int page) {
        return get(
                "posts",
                GhostPostsWithPagination.class,
                MapUtil.createMap(
                        "include", "authors,tags",
                        "limit", limit,
                        "page", page
                ),
                null
        );
    }

    public HttpResponse<GhostPosts> getPostById(String id) {
        return get(
                String.format("posts/%s", id),
                GhostPosts.class,
                MapUtil.createMap("include", "authors,tags"),
                null
        );
    }

    public HttpResponse<GhostPosts> getPostBySlug(String slug) {
        return get(
                String.format("posts/slug/%s", slug),
                GhostPosts.class,
                MapUtil.createMap("include", "authors,tags"),
                null
        );
    }

    public HttpResponse<GhostPagesWithPagination> getPages(int limit, int page) {
        return get(
                "pages",
                GhostPagesWithPagination.class,
                MapUtil.createMap(
                        "include", "tags",
                        "limit", limit,
                        "page", page
                ),
                null
        );
    }

    public HttpResponse<GhostPages> getPageById(String id) {
        return get(
                String.format("pages/%s", id),
                GhostPages.class,
                MapUtil.createMap("include", "tags"),
                null
        );
    }

    public HttpResponse<GhostPages> getPageBySlug(String slug) {
        return get(
                String.format("pages/slug/%s", slug),
                GhostPages.class,
                MapUtil.createMap("include", "tags"),
                null
        );
    }

    public HttpResponse<GhostTagsWithPagination> getTags(int limit, int page) {
        return get(
                "tags",
                GhostTagsWithPagination.class,
                MapUtil.createMap(
                        "limit", limit,
                        "page", page
                ),
                null
        );
    }

    public HttpResponse<GhostTags> getTagById(String id) {
        return get(
                String.format("tags/%s", id),
                GhostTags.class,
                null,
                null
        );
    }

    public HttpResponse<GhostTags> getTagBySlug(String slug) {
        return get(
                String.format("tags/slug/%s", slug),
                GhostTags.class,
                null,
                null
        );
    }

    public HttpResponse<GhostAuthorsWithPagination> getAuthors(int limit, int page) {
        return get(
                "authors",
                GhostAuthorsWithPagination.class,
                MapUtil.createMap(
                        "limit", limit,
                        "page", page
                ),
                null
        );
    }

    public HttpResponse<GhostAuthors> getAuthorById(String id) {
        return get(
                String.format("authors/%s", id),
                GhostAuthors.class,
                null,
                null
        );
    }

    public HttpResponse<GhostAuthors> getAuthorBySlug(String slug) {
        return get(
                String.format("authors/slug/%s", slug),
                GhostAuthors.class,
                null,
                null
        );
    }

    public HttpResponse<GhostInfo> getInfo() {
        return get(
                "settings",
                GhostInfo.class,
                null,
                null
        );
    }
}
