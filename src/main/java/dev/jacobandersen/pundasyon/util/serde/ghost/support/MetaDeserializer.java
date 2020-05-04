package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;

import java.io.IOException;

public class MetaDeserializer extends StdDeserializer<Meta> {
    public MetaDeserializer() {
        super(Meta.class);
    }

    @Override
    public Meta deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        return Meta.builder()
                .title(node.get("meta_title").asText(""))
                .description(node.get("meta_description").asText(""))
                .build();
    }
}
