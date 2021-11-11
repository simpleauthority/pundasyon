package dev.jacobandersen.pundasyon.obj.openweathermap.support;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class OpenWeatherMapTemperatureDrilldown {
    /**
     * Temperature in the morning (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float morning;

    /**
     * Temperature in the day (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float day;

    /**
     * Temperature in the evening (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float evening;

    /**
     * Temperature in the night (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float night;

//    /**
//     * Maximum temperature reached (standard: kelvin, metric: celsius, imperial: fahrenheit)
//     */
//    private Float minimum = null;
//
//    /**
//     * Minimum temperature reached (standard: kelvin, metric: celsius, imperial: fahrenheit)
//     */
//    private Float maximum = null;

    @JsonGetter("morning")
    public float getMorning() {
        return morning;
    }

    @JsonSetter("morn")
    public void setMorning(float morning) {
        this.morning = morning;
    }

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    @JsonGetter("evening")
    public float getEvening() {
        return evening;
    }

    @JsonSetter("eve")
    public void setEvening(float evening) {
        this.evening = evening;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

//    @JsonGetter("minimum")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public Float getMinimum() {
//        return minimum;
//    }
//
//    @JsonSetter(value = "min", nulls = Nulls.SKIP)
//    public void setMinimum(Float minimum) {
//        this.minimum = minimum;
//    }
//
//    @JsonGetter("maximum")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public Float getMaximum() {
//        return maximum;
//    }
//
//    @JsonSetter(value = "max", nulls = Nulls.SKIP)
//    public void setMaximum(Float maximum) {
//        this.maximum = maximum;
//    }
}
