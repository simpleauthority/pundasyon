package dev.jacobandersen.pundasyon.object.opencage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenCageGeography {
    private final Place place;
    private final Bound northeastBound;
    private final Bound southwestBound;

    @Data
    @Builder
    public static class Bound {
        private final double latitude;
        private final double longitude;
    }

    @Data
    @Builder
    public static class Place {
        private final String continent;
        private final String country;
        private final String state;
        private final String region;
        private final String city;
        private final double latitude;
        private final double longitude;
    }
}
