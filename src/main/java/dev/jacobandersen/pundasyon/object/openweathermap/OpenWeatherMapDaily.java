package dev.jacobandersen.pundasyon.object.openweathermap;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.jacobandersen.pundasyon.object.openweathermap.support.OpenWeatherMapMoon;
import dev.jacobandersen.pundasyon.object.openweathermap.support.OpenWeatherMapSun;
import dev.jacobandersen.pundasyon.object.openweathermap.support.OpenWeatherMapTemperatureDrilldown;
import dev.jacobandersen.pundasyon.object.openweathermap.support.OpenWeatherMapWeatherSummary;
import dev.jacobandersen.pundasyon.object.openweathermap.support.OpenWeatherMapWind;

import java.util.List;

public class OpenWeatherMapDaily {
    /**
     * Noon timestamp of the day for which these conditions are valid (Unix timestamp)
     */
    private long time;

    /**
     * Information about the sun for the given day
     */
    private final OpenWeatherMapSun sun = new OpenWeatherMapSun();

    /**
     * Information about the moon for the given day
     */
    private final OpenWeatherMapMoon moon = new OpenWeatherMapMoon();

    /**
     * Forecasted actual temperatures
     */
    private OpenWeatherMapTemperatureDrilldown temperature;

    /**
     * Forecasted apparent temperatures
     */
    private OpenWeatherMapTemperatureDrilldown temperatureFeelsLike;

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
    private float rain = 0f;

    /**
     * Snowfall in preceding hour
     */
    private float snow = 0f;

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

    @JsonGetter("sun")
    public OpenWeatherMapSun getSun() {
        return this.sun;
    }

    @JsonSetter("sunrise")
    public void setSunrise(long sunrise) {
        this.sun.setRise(sunrise * 1000L);
    }

    @JsonSetter("sunset")
    public void setSunset(long sunset) {
        this.sun.setSet(sunset * 1000L);
    }

    @JsonGetter("moon")
    public OpenWeatherMapMoon getMoon() {
        return this.moon;
    }

    @JsonSetter("moonrise")
    public void setMoonrise(long moonrise) {
        this.moon.setRise(moonrise * 1000L);
    }

    @JsonSetter("moonset")
    public void setMoonset(long moonset) {
        this.moon.setSet(moonset * 1000L);
    }

    @JsonSetter("moon_phase")
    public void setMoonPhase(float moonPhase) {
        this.moon.setPhase(moonPhase);
    }

    @JsonGetter("temperature")
    public OpenWeatherMapTemperatureDrilldown getTemperature() {
        return temperature;
    }

    @JsonSetter("temp")
    public void setTemperature(OpenWeatherMapTemperatureDrilldown temperature) {
        this.temperature = temperature;
    }

    @JsonGetter("feels_like")
    public OpenWeatherMapTemperatureDrilldown getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }

    @JsonSetter("feels_like")
    public void setTemperatureFeelsLike(OpenWeatherMapTemperatureDrilldown temperatureFeelsLike) {
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

    @JsonGetter("rainfall")
    public float getRain() {
        return rain;
    }

    @JsonSetter(value = "rain", nulls = Nulls.SKIP)
    public void setRain(float rain) {
        this.rain = rain;
    }

    @JsonGetter("snowfall")
    public float getSnow() {
        return snow;
    }

    @JsonSetter(value = "snow", nulls = Nulls.SKIP)
    public void setSnow(float snow) {
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
