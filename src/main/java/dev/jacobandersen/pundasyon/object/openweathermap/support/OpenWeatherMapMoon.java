package dev.jacobandersen.pundasyon.object.openweathermap.support;

public class OpenWeatherMapMoon {
    /**
     * Time of sunrise (Unix timestamp)
     */
    private long rise;

    /**
     * Time of sunset (Unix timestamp)
     */
    private long set;

    /**
     * Moon phase information
     */
    private final Phase phase = new Phase();


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

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(float value) {
        this.phase.setValue(value);
    }

    public static class Phase {
        private float value;
        private OpenWeatherMapMoonPhase name;

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
            this.name = OpenWeatherMapMoonPhase.valueToPhaseName(value);
        }

        public String getName() {
            return name.cleanName();
        }
    }
}
