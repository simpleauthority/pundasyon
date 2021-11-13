package dev.jacobandersen.pundasyon.object.openweathermap.support;

import com.fasterxml.jackson.annotation.JsonGetter;

public class OpenWeatherMapWind {
    /**
     * Wind speed (standard: meter/sec, metric: meter/sec, imperial: mile/hour)
     */
    private float speed;

    /**
     * Maximum wind speed (standard: meter/sec, metric: meter/sec, imperial: mile/hour)
     */
    private float gustSpeed;

    /**
     * Wind direction information
     */
    private final Direction direction = new Direction();

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @JsonGetter("gust_speed")
    public float getGustSpeed() {
        return this.gustSpeed;
    }

    public void setGustSpeed(float gustSpeed) {
        this.gustSpeed = gustSpeed;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(float direction) {
        this.direction.setDegrees(direction);
    }

    public static class Direction {
        /**
         * Current direction of wind (degrees)
         */
        private float degrees;

        /**
         * Current direction of wind (cardinal)
         */
        private OpenWeatherMapWindDirection cardinal;

        public float getDegrees() {
            return degrees;
        }

        public void setDegrees(float degrees) {
            this.degrees = degrees;
            this.cardinal = OpenWeatherMapWindDirection.valueToDirection(degrees);
        }

        public String getCardinal() {
            return cardinal.cleanName();
        }
    }
}
