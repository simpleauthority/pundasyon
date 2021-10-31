package dev.jacobandersen.pundasyon.obj.openweathermap;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherMapResponse {
    private OpenWeatherMapConditions conditions = new OpenWeatherMapConditions();
    private List<OpenWeatherMapHourly> hourly = new ArrayList<>();
    private List<OpenWeatherMapDaily> daily = new ArrayList<>();
    private List<OpenWeatherMapWeatherAlert> alerts = new ArrayList<>();

    @JsonGetter("conditions")
    public OpenWeatherMapConditions getConditions() {
        return conditions;
    }

    @JsonSetter(value = "current", nulls = Nulls.SKIP)
    public void setConditions(OpenWeatherMapConditions conditions) {
        this.conditions = conditions;
    }

    @JsonGetter("hourly")
    public List<OpenWeatherMapHourly> getHourly() {
        return hourly;
    }

    @JsonSetter(value = "hourly", nulls = Nulls.SKIP)
    public void setHourly(List<OpenWeatherMapHourly> hourly) {
        this.hourly = hourly;
    }

    @JsonGetter("daily")
    public List<OpenWeatherMapDaily> getDaily() {
        return daily;
    }

    @JsonSetter(value = "daily", nulls = Nulls.SKIP)
    public void setDaily(List<OpenWeatherMapDaily> daily) {
        this.daily = daily;
    }

    @JsonGetter("alerts")
    public List<OpenWeatherMapWeatherAlert> getAlerts() {
        return alerts;
    }

    @JsonSetter(value = "alerts", nulls = Nulls.SKIP)
    public void setAlerts(List<OpenWeatherMapWeatherAlert> alerts) {
        this.alerts = alerts;
    }
}
