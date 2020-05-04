package dev.jacobandersen.pundasyon.util.serde.ghost.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.support.Dates;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesDeserializer extends StdDeserializer<Dates> {
    private final SimpleDateFormat dateFormat;

    public DatesDeserializer() {
        super(Dates.class);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    }

    @Override
    public Dates deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        Date created;
        try {
            created = dateFormat.parse(node.get("created_at").asText(""));
        } catch (ParseException ignored) {
            created = null;
        }

        Date published;
        try {
            published = dateFormat.parse(node.get("published_at").asText(""));
        } catch (ParseException ignored) {
            published = null;
        }

        Date updated;
        try {
            updated = dateFormat.parse(node.get("updated_at").asText(""));
        } catch (ParseException ignored) {
            updated = null;
        }

        return Dates.builder()
                .created(created)
                .published(published)
                .updated(updated)
                .build();
    }
}
