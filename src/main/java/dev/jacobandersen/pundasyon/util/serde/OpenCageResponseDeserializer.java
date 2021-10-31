package dev.jacobandersen.pundasyon.util.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.OpenCageResponse;

import java.io.IOException;

public class OpenCageResponseDeserializer extends StdDeserializer<OpenCageResponse> {
    public OpenCageResponseDeserializer() {
        super(OpenCageResponse.class);
    }

    @Override
    public OpenCageResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.readValueAsTree();

        JsonNode result = node.get("results").get(0);
        if (result == null) {
            return null;
        }

        JsonNode annotations = result.get("annotations");
        JsonNode components = result.get("components");
        JsonNode geometry = result.get("geometry");

        String city = components.has("city") ?
                components.get("city").asText() :
                (components.has("town") ?
                        components.get("town").asText() : null);

        return OpenCageResponse.builder()
                .callingCode(annotations.get("callingcode").asInt())
                .country(components.get("country").asText())
                .flag(annotations.get("flag").asText())
                .city(city)
                .latitude(geometry.get("lat").floatValue())
                .longitude(geometry.get("lng").floatValue())
                .build();
    }
}
