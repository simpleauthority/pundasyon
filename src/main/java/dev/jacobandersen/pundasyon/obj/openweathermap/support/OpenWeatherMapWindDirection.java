package dev.jacobandersen.pundasyon.obj.openweathermap.support;

import dev.jacobandersen.pundasyon.util.EnumUtil;

public enum OpenWeatherMapWindDirection {
    NORTH,
    NORTH_NORTHEAST,
    NORTHEAST,
    EAST_NORTHEAST,
    EAST,
    EAST_SOUTHEAST,
    SOUTHEAST,
    SOUTH_SOUTHEAST,
    SOUTH,
    SOUTH_SOUTHWEST,
    SOUTHWEST,
    WEST_SOUTHWEST,
    WEST,
    WEST_NORTHWEST,
    NORTHWEST,
    NORTH_NORTHWEST;

    public String cleanName() {
        return EnumUtil.toString(this, "-");
    }

    public static OpenWeatherMapWindDirection valueToDirection(float value) {
        if (value < 0f || value > 360f) {
            throw new IllegalArgumentException("Meteorological direction is clamped between 0 and 360 degrees.");
        }

        if (value >= 0f && value < 11.25f) {
            return NORTH;
        } else if (value >= 11.25f && value < 33.75f) {
            return NORTH_NORTHEAST;
        } else if (value >= 33.75f && value < 56.25f) {
            return NORTHEAST;
        } else if (value >= 56.25f && value < 78.75f) {
            return EAST_NORTHEAST;
        } else if (value >= 78.75f && value < 101.25f) {
            return EAST;
        } else if (value >= 101.25f && value < 123.75f) {
            return EAST_SOUTHEAST;
        } else if (value >= 123.75f && value < 146.25f) {
            return SOUTHEAST;
        } else if (value >= 146.25f && value < 168.75f) {
            return SOUTH_SOUTHEAST;
        } else if (value >= 168.75f && value < 191.25f) {
            return SOUTH;
        } else if (value >= 191.25f && value < 213.75f) {
            return SOUTH_SOUTHWEST;
        } else if (value >= 213.75f && value < 236.25f) {
            return SOUTHWEST;
        } else if (value >= 236.25f && value < 258.75f) {
            return WEST_SOUTHWEST;
        } else if (value >= 258.75f && value < 281.25f) {
            return WEST;
        } else if (value >= 281.25f && value < 303.75f) {
            return WEST_NORTHWEST;
        } else if (value >= 303.75f && value < 326.25f) {
            return NORTHWEST;
        } else if (value >= 326.25f && value < 348.75f) {
            return NORTH_NORTHWEST;
        } else {
            return NORTH;
        }
    }
}
