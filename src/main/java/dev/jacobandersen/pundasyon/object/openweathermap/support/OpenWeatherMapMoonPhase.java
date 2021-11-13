package dev.jacobandersen.pundasyon.object.openweathermap.support;

import dev.jacobandersen.pundasyon.util.EnumUtil;

public enum OpenWeatherMapMoonPhase {
    NEW,
    WAXING_CRESCENT,
    FIRST_QUARTER,
    WAXING_GIBOUS,
    FULL,
    WANING_GIBOUS,
    LAST_QUARTER,
    WANING_CRESCENT;

    public String cleanName() {
        return EnumUtil.toString(this);
    }

    public static OpenWeatherMapMoonPhase valueToPhaseName(float value) {
        if (value < 0f || value > 1f) {
            throw new IllegalArgumentException("Moon phase value is clamped between 0f and 1f.");
        }

        if (value == 0f) {
            return NEW;
        } else if (value < 0.25f) {
            return WAXING_CRESCENT;
        } else if (value == 0.25f) {
            return FIRST_QUARTER;
        } else if (value < 0.5f) {
            return WAXING_GIBOUS;
        } else if (value == 0.5f) {
            return FULL;
        } else if (value < 0.75f) {
            return WANING_GIBOUS;
        } else if (value == 0.75f) {
            return LAST_QUARTER;
        } else if (value < 1f) {
            return WANING_CRESCENT;
        } else {
            return NEW;
        }
    }
}
