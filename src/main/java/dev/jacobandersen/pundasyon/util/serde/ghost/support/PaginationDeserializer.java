package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.Pagination;

import java.io.IOException;

public class PaginationDeserializer extends StdDeserializer<Pagination> {
    public PaginationDeserializer() {
        super(Pagination.class);
    }

    @Override
    public Pagination deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        return Pagination.builder()
                .page(node.get("page").asInt())
                .limit(node.get("limit").asInt())
                .pages(node.get("pages").asInt())
                .total(node.get("total").asInt())
                .next(node.get("next").asInt(-1))
                .next(node.get("prev").asInt(-1))
                .build();
    }
}
