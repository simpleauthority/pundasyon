package dev.jacobandersen.pundasyon.obj;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.OpenCageResponseDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = OpenCageResponseDeserializer.class)
public class OpenCageResponse {
    private int callingCode;
    private String country;
    private String flag;
    private String city;
    private long civilSunrise;
    private long civilSunset;
    private float latitude;
    private float longitude;
}
