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
@Table(name = "geographic_location_driving_metadata")
@AllArgsConstructor
@Builder
public class GeographicLocationDrivingMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driving_metadata_id", nullable = false)
    private long drivingMetadataId;

    @Column(name = "side_of_road")
    private String sideOfRoad;

    @Column(name = "units_of_speed")
    private String unitsOfSpeed;

    protected GeographicLocationDrivingMetadata() {}

    public GeographicLocationDrivingMetadata(String sideOfRoad, String unitsOfSpeed) {
        this.sideOfRoad = sideOfRoad;
        this.unitsOfSpeed = unitsOfSpeed;
    }

    /**
     * A unique ID representing this driving metadata.
     * @return the driving metadata ID
     */
    public long getDrivingMetadataId() {
        return drivingMetadataId;
    }

    /**
     * Gets the side of the road designated for driving at the connected location.
     * @return the side of the road
     */
    public String getSideOfRoad() {
        return sideOfRoad;
    }

    /**
     * Gets the units of speed used at the connected location.
     * @return the units of speed
     */
    public String getUnitsOfSpeed() {
        return unitsOfSpeed;
    }

    @Override
    public String toString() {
        return "GeographicLocationDrivingMetadata{" +
                "drivingMetadataId=" + drivingMetadataId +
                ", sideOfRoad='" + sideOfRoad + '\'' +
                ", unitsOfSpeed='" + unitsOfSpeed + '\'' +
                '}';
    }
}
