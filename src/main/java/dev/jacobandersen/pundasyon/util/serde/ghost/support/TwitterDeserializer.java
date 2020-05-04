package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.Twitter;

import java.io.IOException;

public class TwitterDeserializer extends StdDeserializer<Twitter> {
    public TwitterDeserializer() {
        super(Twitter.class);
    }

    @Override
    public Twitter deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        return Twitter.builder()
                .image(node.get("twitter_image").asText(""))
                .title(node.get("twitter_title").asText(""))
                .description(node.get("twitter_description").asText(""))
                .build();
    }
}
