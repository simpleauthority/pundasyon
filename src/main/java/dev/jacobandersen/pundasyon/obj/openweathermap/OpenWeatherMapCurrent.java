package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapCurrent {
    private Float temp;
    @JsonProperty("feels_like")
    private Float feelsLike;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("dew_point")
    private Float dewPoint;
    private Integer clouds;
    private Float uvi;
    private Integer visibility;
    @JsonProperty("wind_speed")
    private Float windSpeed;
    @JsonProperty("wind_gust")
    private Float windGust;
    @JsonProperty("wind_deg")
    private Float windDeg;
    private Integer rain;
    private Integer snow;
}
