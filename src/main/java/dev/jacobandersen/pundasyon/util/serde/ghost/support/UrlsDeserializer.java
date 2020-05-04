package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.Urls;

import java.io.IOException;

public class UrlsDeserializer extends StdDeserializer<Urls> {
    public UrlsDeserializer() {
        super(Urls.class);
    }

    @Override
    public Urls deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        return Urls.builder()
                .canonicalUrl(node.get("canonical_url").asText(""))
                .url(node.get("url").asText(""))
                .build();
    }
}
