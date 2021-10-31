package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapLastHourPrecipitationDetails;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapWeatherSummary;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapWindDirection;

import java.util.List;

public class OpenWeatherMapConditions {
    /**
     * Time for which conditions are valid (Unix timestamp)
     */
    private long time;

    /**
     * Time of sunrise for the current day (Unix timestamp)
     */
    private long sunrise;

    /**
     * Time of sunset for the current day (Unix timestamp)
     */
    private long sunset;

    /**
     * Current actual temperature (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float temperature;

    /**
     * Current apparent temperature (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float temperatureFeelsLike;

    /**
     * Current atmospheric pressure at sea level (hectopascals)
     */
    private float pressure;

    /**
     * Current air humidity (percentage)
     */
    private int humidity;

    /**
     * Temperature below which dew will form (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float dewPoint;

    /**
     * Current cloud cover (percentage)
     */
    private int cloudCover;

    /**
     * Current UV index (multiply by 25 for milliwatts per square meter)
     */
    private int uvIndex;

    /**
     * Current average visibility (meters)
     */
    private int visibility;

    /**
     * Current wind speed (standard: meter/sec, metric: meter/sec, imperial: mile/hour)
     */
    private float windSpeed;

    /**
     * Current maximum wind speed (standard: meter/sec, metric: meter/sec, imperial: mile/hour)
     */
    private float windGustSpeed;

    /**
     * Current direction of wind (degrees)
     */
    private float windDirection;

    /**
     * Current direction of wind (cardinal)
     */
    private OpenWeatherMapWindDirection windCardinalDirection;

    /**
     * Current rainfall
     */
    private OpenWeatherMapLastHourPrecipitationDetails rain = new OpenWeatherMapLastHourPrecipitationDetails();

    /**
     * Current snowfall
     */
    private OpenWeatherMapLastHourPrecipitationDetails snow = new OpenWeatherMapLastHourPrecipitationDetails();

    /**
     * Summary of current conditions
     */
    private List<OpenWeatherMapWeatherSummary> summary;

    @JsonGetter("time")
    public long getTime() {
        return time;
    }

    @JsonSetter("dt")
    public void setTime(long time) {
        this.time = time;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    @JsonGetter("temperature")
    public float getTemperature() {
        return temperature;
    }

    @JsonSetter("temp")
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @JsonGetter("feels_like")
    public float getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }

    @JsonSetter("feels_like")
    public void setTemperatureFeelsLike(float temperatureFeelsLike) {
        this.temperatureFeelsLike = temperatureFeelsLike;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonGetter("dew_point")
    public float getDewPoint() {
        return dewPoint;
    }

    @JsonSetter("dew_point")
    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    @JsonGetter("cloud_cover")
    public int getCloudCover() {
        return cloudCover;
    }

    @JsonSetter("clouds")
    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

    @JsonGetter("uv_index")
    public int getUvIndex() {
        return uvIndex;
    }

    @JsonSetter("uvi")
    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @JsonGetter("wind_speed")
    public float getWindSpeed() {
        return windSpeed;
    }

    @JsonSetter("wind_speed")
    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonGetter("wind_gust_speed")
    public float getWindGustSpeed() {
        return windGustSpeed;
    }

    @JsonSetter(value = "wind_gust", nulls = Nulls.SKIP)
    public void setWindGustSpeed(float windGustSpeed) {
        this.windGustSpeed = windGustSpeed;
    }

    @JsonGetter("wind_direction")
    public float getWindDirection() {
        return windDirection;
    }

    @JsonSetter("wind_deg")
    public void setWindDirection(float windDirection) {
        this.windDirection = windDirection;
        this.windCardinalDirection = OpenWeatherMapWindDirection.valueToDirection(windDirection);
    }

    @JsonGetter("wind_cardinal_direction")
    public String getWindCardinalDirection() {
        return windCardinalDirection.cleanName();
    }

    @JsonGetter("rainfall")
    public OpenWeatherMapLastHourPrecipitationDetails getRain() {
        return rain;
    }

    @JsonSetter(value = "rain", nulls = Nulls.SKIP)
    public void setRain(OpenWeatherMapLastHourPrecipitationDetails rain) {
        this.rain = rain;
    }

    @JsonGetter("snowfall")
    public OpenWeatherMapLastHourPrecipitationDetails getSnow() {
        return snow;
    }

    @JsonSetter(value = "snow", nulls = Nulls.SKIP)
    public void setSnow(OpenWeatherMapLastHourPrecipitationDetails snow) {
        this.snow = snow;
    }

    @JsonGetter("summary")
    public List<OpenWeatherMapWeatherSummary> getSummary() {
        return summary;
    }

    @JsonSetter("weather")
    public void setSummary(List<OpenWeatherMapWeatherSummary> summary) {
        this.summary = summary;
    }
}
