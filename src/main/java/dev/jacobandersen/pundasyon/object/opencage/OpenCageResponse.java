package dev.jacobandersen.pundasyon.object.opencage;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocation;
import dev.jacobandersen.pundasyon.util.convert.ConvertibleToGeographicLocation;
import dev.jacobandersen.pundasyon.util.serialization.OpenCageResponseDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = OpenCageResponseDeserializer.class)
public class OpenCageResponse extends ConvertibleToGeographicLocation {
    private Source source;
    private OpenCageGeography geography;
    private OpenCageMetadata metadata;

    @Override
    public GeographicLocation convert() {
        return convert0(this);
    }

    public enum Source {
        OPENCAGE,
        DATABASE
    }
}
