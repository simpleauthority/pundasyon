package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapWeatherSummary;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapWind;

import java.util.List;
import java.util.Map;

public class OpenWeatherMapHourly {
    /**
     * Time for which conditions are valid for next hour (Unix timestamp)
     */
    private long time;

    /**
     * Forecasted actual temperature (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float temperature;

    /**
     * Forecasted apparent temperature (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float temperatureFeelsLike;

    /**
     * Forecasted atmospheric pressure at sea level (hectopascals)
     */
    private float pressure;

    /**
     * Forecasted air humidity (percentage)
     */
    private int humidity;

    /**
     * Forecasted temperature below which dew will form (standard: kelvin, metric: celsius, imperial: fahrenheit)
     */
    private float dewPoint;

    /**
     * Forecasted cloud cover (percentage)
     */
    private int cloudCover;

    /**
     * Forecasted UV index (multiply by 25 for milliwatts per square meter)
     */
    private int uvIndex;

    /**
     * Forecasted average visibility (meters)
     */
    private int visibility;

    /**
     * Forecasted wind information
     */
    private final OpenWeatherMapWind wind = new OpenWeatherMapWind();

    /**
     * Forecasted probability that it will rain or snow during this hour
     */
    private float probabilityOfPrecipitation;

    /**
     * Rainfall in preceding hour
     */
    private float rain = 0.0f;

    /**
     * Snowfall in preceding hour
     */
    private float snow = 0.0f;

    /**
     * Summary of forecasted conditions
     */
    private List<OpenWeatherMapWeatherSummary> summary;

    @JsonGetter("time")
    public long getTime() {
        return time;
    }

    @JsonSetter("dt")
    public void setTime(long time) {
        this.time = time * 1000L;
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

    @JsonGetter("wind")
    public OpenWeatherMapWind getWind() {
        return this.wind;
    }

    @JsonSetter("wind_speed")
    public void setWindSpeed(float windSpeed) {
        this.wind.setSpeed(windSpeed);
    }

    @JsonSetter(value = "wind_gust", nulls = Nulls.SKIP)
    public void setWindGustSpeed(float windGustSpeed) {
        this.wind.setGustSpeed(windGustSpeed);
    }

    @JsonSetter("wind_deg")
    public void setWindDirection(float windDirection) {
        this.wind.setDirection(windDirection);
    }

    @JsonGetter("probability_of_precipitation")
    public float getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    @JsonSetter("pop")
    public void setProbabilityOfPrecipitation(float probabilityOfPrecipitation) {
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }

    @JsonGetter("rainfall_last_hour")
    public float getRain() {
        return rain;
    }

    @JsonSetter(value = "rain", nulls = Nulls.SKIP)
    public void setRain(Map<String, String> rain) {
        this.rain = Float.parseFloat(rain.get("1h"));
    }

    @JsonGetter("snowfall_last_hour")
    public float getSnow() {
        return snow;
    }

    @JsonSetter(value = "snow", nulls = Nulls.SKIP)
    public void setSnow(Map<String, String> snow) {
        this.snow = Float.parseFloat(snow.get("1h"));
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
