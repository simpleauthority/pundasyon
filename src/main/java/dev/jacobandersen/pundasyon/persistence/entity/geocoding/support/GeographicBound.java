package dev.jacobandersen.pundasyon.persistence.entity.geocoding.support;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "geographic_bound")
@AllArgsConstructor
@Builder
public class GeographicBound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bound_id", nullable = false)
    private long boundId;

    @Column(name = "northeast_latitude", nullable = false)
    private double northeastLatitude;

    @Column(name = "northeast_longitude", nullable = false)
    private double northeastLongitude;

    @Column(name = "southwest_latitude", nullable = false)
    private double southwestLatitude;

    @Column(name = "southwest_longitude", nullable = false)
    private double southwestLongitude;

    protected GeographicBound() {}

    public GeographicBound(double northeastLatitude, double northeastLongitude, double southwestLatitude, double southwestLongitude, List<GeographicLocation> containedLocations) {
        this.northeastLatitude = northeastLatitude;
        this.northeastLongitude = northeastLongitude;
        this.southwestLatitude = southwestLatitude;
        this.southwestLongitude = southwestLongitude;
    }

    /**
     * A unique ID representing this geographic bound.
     * @return the bound ID
     */
    public long getBoundId() {
        return boundId;
    }

    /**
     * The northeastern-most latitude of the bound.
     * @return the latitude
     */
    public double getNortheastLatitude() {
        return northeastLatitude;
    }

    /**
     * The northeastern-most longitude of the bound.
     * @return the longitude
     */
    public double getNortheastLongitude() {
        return northeastLongitude;
    }

    /**
     * The southwestern-most latitude of the bound.
     * @return the latitude
     */
    public double getSouthwestLatitude() {
        return southwestLatitude;
    }

    /**
     * The southwestern-most longitude of the bound.
     * @return the longitude
     */
    public double getSouthwestLongitude() {
        return southwestLongitude;
    }

    @Override
    public String toString() {
        return "GeographicBound{" +
                "boundId=" + boundId +
                ", northeastLatitude=" + northeastLatitude +
                ", northeastLongitude=" + northeastLongitude +
                ", southwestLatitude=" + southwestLatitude +
                ", southwestLongitude=" + southwestLongitude +
                '}';
    }
}
