package dev.jacobandersen.pundasyon.util.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import dev.jacobandersen.pundasyon.object.opencage.OpenCageGeography;
import dev.jacobandersen.pundasyon.object.opencage.OpenCageMetadata;
import dev.jacobandersen.pundasyon.object.opencage.OpenCageResponse;

import java.io.IOException;

public class OpenCageResponseDeserializer extends StdDeserializer<OpenCageResponse> {
    public OpenCageResponseDeserializer() {
        super(OpenCageResponse.class);
    }

    @Override
    public OpenCageResponse deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.readValueAsTree();

        JsonNode result = node.get("results").get(0);
        if (result == null) {
            return null;
        }

        JsonNode annotations = result.get("annotations");
        JsonNode currency = annotations.get("currency");
        JsonNode roadInfo = annotations.get("roadinfo");
        JsonNode timezone = annotations.get("timezone");

        JsonNode bounds = result.get("bounds");
        JsonNode neBound = bounds.get("northeast");
        JsonNode swBound = bounds.get("southwest");

        JsonNode geometry = result.get("geometry");
        JsonNode components = result.get("components");

        return OpenCageResponse.builder()
                .source(OpenCageResponse.Source.OPENCAGE)
                .geography(OpenCageGeography.builder()
                        .place(OpenCageGeography.Place.builder()
                                .latitude(geometry.get("lat").doubleValue())
                                .longitude(geometry.get("lng").doubleValue())
                                .continent(getSafe(components.get("continent")).asText(null))
                                .country(findTextFieldOrNull(components, "country", "country_name", "country_code").asText())
                                .state(findTextFieldOrNull(components,"state", "state_code", "province", "state_district").asText())
                                .region(findTextFieldOrNull(components, "county", "county_code", "region", "island").asText())
                                .city(findTextFieldOrNull(components, "city", "city_district", "district", "town",
                                        "township", "municipality", "local_administrative_area", "locality",
                                        "village", "hamlet", "suburb", "subcounty",
                                        "borough", "quarter", "neighbourhood", "croft", "department").asText())
                                .build())
                        .northeastBound(OpenCageGeography.Bound.builder()
                                .latitude(neBound.get("lat").doubleValue())
                                .longitude(neBound.get("lng").doubleValue())
                                .build())
                        .southwestBound(OpenCageGeography.Bound.builder()
                                .latitude(swBound.get("lat").doubleValue())
                                .longitude(swBound.get("lng").doubleValue())
                                .build())
                        .build())
                .metadata(OpenCageMetadata.builder()
                        .timezone(OpenCageMetadata.Timezone.builder()
                                .name(getSafe(timezone.get("name")).asText())
                                .shortName(getSafe(timezone.get("short_name")).asText())
                                .inDaylightSavings(timezone.get("now_in_dst").asBoolean())
                                .offsetFromUtc(timezone.get("offset_sec").longValue() * 1000L)
                                .build())
                        .driving(OpenCageMetadata.Driving.builder()
                                .sideOfRoad(getSafe(roadInfo.get("drive_on")).asText())
                                .unitsOfSpeed(getSafe(roadInfo.get("speed_in")).asText())
                                .build())
                        .currency(OpenCageMetadata.Currency.builder()
                                .name(getSafe(currency.get("name")).asText())
                                .symbol(getSafe(currency.get("symbol")).asText())
                                .unambiguousSymbol(getSafe(currency.get("disambiguate_symbol")).asText())
                                .placeSymbolFirst(getSafe(currency.get("symbol_first")).asBoolean())
                                .decimalMark(getSafe(currency.get("decimal_mark")).asText())
                                .thousandsSeparator(getSafe(currency.get("thousands_separator")).asText())
                                .smallestDenomination(currency.get("smallest_denomination").intValue())
                                .subunitName(getSafe(currency.get("subunit")).asText())
                                .subunitsInUnit(currency.get("subunit_to_unit").intValue())
                                .build())
                        .miscellaneous(OpenCageMetadata.Miscellaneous.builder()
                                .flag(getSafe(annotations.get("flag")).asText())
                                .callingCode(annotations.get("callingcode").intValue())
                                .qibla(annotations.get("qibla").floatValue())
                                .build())
                        .build())
                .build();
    }

    private JsonNode getSafe(JsonNode node) {
        if (node == null) {
            return new TextNode(null);
        } else {
            return node;
        }
    }

    private JsonNode findTextFieldOrNull(JsonNode objectToSearch, String... choices) {
        JsonNode found = new TextNode(null);

        for (String choice : choices) {
            if (objectToSearch.has(choice)) {
                found = objectToSearch.get(choice);
                break;
            }
        }

        return found;
    }
}
