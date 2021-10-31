package dev.jacobandersen.pundasyon.obj.openweathermap.support;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

public class OpenWeatherMapLastHourPrecipitationDetails {
    /**
     * Volume of precipitation in last hour (millimeters)
     */
    private double lastHour = 0.0f;

    @JsonGetter("last_hour")
    public double getLastHour() {
        return lastHour;
    }

    @JsonSetter(value = "1h", nulls = Nulls.SKIP)
    public void setLastHour(double lastHour) {
        this.lastHour = lastHour;
    }
}
