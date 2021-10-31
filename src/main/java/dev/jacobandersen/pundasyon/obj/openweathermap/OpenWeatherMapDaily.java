package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapMoonPhase;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapLastHourPrecipitationDetails;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapTemperatureDrilldown;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapWeatherSummary;
import dev.jacobandersen.pundasyon.obj.openweathermap.support.OpenWeatherMapWindDirection;

import java.util.List;

public class OpenWeatherMapDaily {
    /**
     * Noon timestamp of the day for which these conditions are valid (Unix timestamp)
     */
    private long time;

    /**
     * Time of sunrise for the given day (Unix timestamp)
     */
    private long sunrise;

    /**
     * Time of sunset for the given day (Unix timestamp)
     */
    private long sunset;

    /**
     * Time of moonrise for the given day (Unix timestamp)
     */
    private long moonrise;

    /**
     * Time of moonset for the given day (Unix timestamp)
     */
    private long moonset;

    /**
     * Value of phase of the moon for the given day
     */
    private float moonPhase;

    /**
     * Name of phase of the moon for the given day
     */
    private OpenWeatherMapMoonPhase moonPhaseName;

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
     * Forecasted average visibility (meters)
     */
    private int visibility;

    /**
     * Forecasted wind speed (standard: meter/sec, metric: meter/sec, imperial: mile/hour)
     */
    private float windSpeed;

    /**
     * Forecasted maximum wind speed (standard: meter/sec, metric: meter/sec, imperial: mile/hour)
     */
    private float windGustSpeed = -1.0f;

    /**
     * Forecasted direction of wind (degrees)
     */
    private float windDirection;

    /**
     * Forecasted direction of wind (cardinal)
     */
    private OpenWeatherMapWindDirection windCardinalDirection;

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

    public long getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(long moonrise) {
        this.moonrise = moonrise;
    }

    public long getMoonset() {
        return moonset;
    }

    public void setMoonset(long moonset) {
        this.moonset = moonset;
    }

    @JsonGetter("moon_phase_value")
    public float getMoonPhase() {
        return moonPhase;
    }

    @JsonSetter("moon_phase")
    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
        this.moonPhaseName = OpenWeatherMapMoonPhase.valueToPhaseName(moonPhase);
    }

    @JsonGetter("moon_phase")
    public String getMoonPhaseName() {
        return moonPhaseName.cleanName();
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
