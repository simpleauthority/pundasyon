package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthor;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;
import dev.jacobandersen.pundasyon.util.ConditionalUtil;

import java.io.IOException;

public class GhostAuthorDeserializer extends StdDeserializer<GhostAuthor> {
    public GhostAuthorDeserializer() {
        super(GhostAuthor.class);
    }

    @Override
    public GhostAuthor deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();
        Meta meta = tree.traverse(p.getCodec()).readValueAs(Meta.class);

        GhostAuthor.GhostAuthorBuilder author = GhostAuthor.builder()
                .id(tree.get("id").asInt(-1))
                .slug(tree.get("slug").asText(""))
                .name(tree.get("name").asText(""))
                .profileImage(tree.get("profile_image").asText(""))
                .coverImage(tree.get("cover_image").asText(""))
                .bio(tree.get("bio").asText(""))
                .website(tree.get("website").asText(""))
                .location(tree.get("location").asText(""))
                .facebook(tree.get("facebook").asText(""))
                .twitter(tree.get("twitter").asText(""))
                .url(tree.get("url").asText(""))
                .meta(meta);

        if (ConditionalUtil.hasJsonStructure(tree, "count", "count.posts")) {
            author = author.postCount(tree.get("count").get("posts").asInt(-1));
        }

        return author.build();
    }
}
