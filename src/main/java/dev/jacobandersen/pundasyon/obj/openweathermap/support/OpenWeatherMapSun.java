package dev.jacobandersen.pundasyon.obj.openweathermap.support;

public class OpenWeatherMapSun {
    /**
     * Time of sunrise for the current day (Unix timestamp)
     */
    private long rise;

    /**
     * Time of sunset for the current day (Unix timestamp)
     */
    private long set;

    public long getRise() {
        return rise;
    }

    public void setRise(long rise) {
        this.rise = rise;
    }

    public long getSet() {
        return set;
    }

    public void setSet(long set) {
        this.set = set;
    }
}
