package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.CodeInjection;

import java.io.IOException;

public class CodeInjectionDeserializer extends StdDeserializer<CodeInjection> {
    public CodeInjectionDeserializer() {
        super(CodeInjection.class);
    }

    @Override
    public CodeInjection deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        return CodeInjection.builder()
                .header(node.get("codeinjection_head").asText(""))
                .footer(node.get("codeinjection_foot").asText(""))
                .build();
    }
}
