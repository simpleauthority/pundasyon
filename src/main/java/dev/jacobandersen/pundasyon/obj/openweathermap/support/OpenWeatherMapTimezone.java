package dev.jacobandersen.pundasyon.obj.openweathermap.support;

public class OpenWeatherMapTimezone {
    private String zone;
    private long offset;

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public long getOffset() {
        return offset * 1000;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}
