package dev.jacobandersen.pundasyon.obj.openweathermap.support;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

public class OpenWeatherMapPrecipitationDetails {
    /**
     * Volume of precipitation in last hour (millimeters)
     */
    private float lastHour = 0.0f;

    @JsonGetter("last_hour")
    public float getLastHour() {
        return lastHour;
    }

    @JsonSetter(value = "1h", nulls = Nulls.SKIP)
    public void setLastHour(float lastHour) {
        this.lastHour = lastHour;
    }
}
