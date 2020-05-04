package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.OpenGraph;

import java.io.IOException;

public class OpenGraphDeserializer extends StdDeserializer<OpenGraph> {
    public OpenGraphDeserializer() {
        super(OpenGraph.class);
    }

    @Override
    public OpenGraph deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        return OpenGraph.builder()
                .image(node.get("og_image").asText(""))
                .title(node.get("title").asText(""))
                .description(node.get("description").asText(""))
                .build();
    }
}
