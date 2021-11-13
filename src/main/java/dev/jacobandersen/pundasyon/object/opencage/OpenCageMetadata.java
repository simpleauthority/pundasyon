package dev.jacobandersen.pundasyon.object.opencage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenCageMetadata {
    private final Timezone timezone;
    private final Driving driving;
    private final Currency currency;
    private final Miscellaneous miscellaneous;

    @Data
    @Builder
    public static class Timezone {
        private String name;
        private String shortName;
        private boolean inDaylightSavings;
        private long offsetFromUtc;
    }

    @Data
    @Builder
    public static class Driving {
        private String sideOfRoad;
        private String unitsOfSpeed;
    }

    @Data
    @Builder
    public static class Currency {
        private String name;
        private String symbol;
        private String unambiguousSymbol;
        private boolean placeSymbolFirst;
        private String decimalMark;
        private String thousandsSeparator;
        private int smallestDenomination;
        private String subunitName;
        private int subunitsInUnit;
    }

    @Data
    @Builder
    public static class Miscellaneous {
        private String flag;
        private int callingCode;
        private float qibla;
    }
}
