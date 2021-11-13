package dev.jacobandersen.pundasyon.persistence.entity.geocoding.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geographic_location_timezone_metadata")
@AllArgsConstructor
@Builder
public class GeographicLocationTimezoneMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timezone_metadata_id", nullable = false)
    private long timezoneMetadataId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "in_daylight_savings")
    private boolean inDaylightSavings;

    @Column(name = "offset_from_utc")
    private long offsetFromUtc;

    protected GeographicLocationTimezoneMetadata() {}

    public GeographicLocationTimezoneMetadata(String name, String shortName, boolean inDaylightSavings, long offsetFromUtc) {
        this.name = name;
        this.shortName = shortName;
        this.inDaylightSavings = inDaylightSavings;
        this.offsetFromUtc = offsetFromUtc;
    }

    /**
     * A unique ID representing this timezone metadata.
     * @return the timezone metadata ID
     */
    public long getTimezoneMetadataId() {
        return timezoneMetadataId;
    }

    /**
     * Gets the name of the timezone at the connected location.
     * @return the timezone name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the shortened name of the timezone at the connected location.
     * @return the shortened timezone name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Gets whether the connected location is currently in daylight savings.
     * @return true or false
     */
    public boolean isInDaylightSavings() {
        return inDaylightSavings;
    }

    /**
     * Gets the offset from UTC of the timezone at the connected location in milliseconds.
     * @return the offset from UTC
     */
    public long getOffsetFromUtc() {
        return offsetFromUtc;
    }

    @Override
    public String toString() {
        return "GeographicLocationTimezoneMetadata{" +
                "timezoneMetadataId=" + timezoneMetadataId +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", inDaylightSavings=" + inDaylightSavings +
                ", offsetFromUtc=" + offsetFromUtc +
                '}';
    }
}
