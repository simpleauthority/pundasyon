package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPost;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPosts;

import java.io.IOException;
import java.util.List;

public class GhostPostsDeserializer extends StdDeserializer<GhostPosts> {
    public GhostPostsDeserializer() {
        super(GhostPosts.class);
    }

    @Override
    public GhostPosts deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return GhostPosts.builder()
                .posts(p.readValueAsTree().get("posts").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostPost>>() {
                }))
                .build();
    }
}
