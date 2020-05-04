package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapHourly {
    private Long time;
    private Float temp;
    @JsonProperty("feels_like")
    private Float feelsLike;
    private Integer humidity;
    @JsonProperty("dew_point")
    private Float dewPoint;
    private Integer clouds;
    @JsonProperty("wind_speed")
    private Float windSpeed;
    @JsonProperty("wind_deg")
    private Integer windDeg;
    private PrecipitationDetails rain;
    private PrecipitationDetails snow;

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("dt")
    public void setTime(Long time) {
        this.time = time;
    }

    @Data
    public static class PrecipitationDetails {
        private Float lastHour;

        @JsonProperty("lastHour")
        public Float getLastHour() {
            return lastHour;
        }

        @JsonProperty("1h")
        public void setLastHour(Float lastHour) {
            this.lastHour = lastHour;
        }
    }
}
