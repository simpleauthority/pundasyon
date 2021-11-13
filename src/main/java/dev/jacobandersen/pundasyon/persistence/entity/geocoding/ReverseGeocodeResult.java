package dev.jacobandersen.pundasyon.persistence.entity.geocoding;

import dev.jacobandersen.pundasyon.object.opencage.OpenCageResponse;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocation;
import dev.jacobandersen.pundasyon.util.convert.ConvertibleToOpenCageResponse;
import lombok.Builder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "reverse_geocode_result", indexes = @Index(name="latLonIdx", columnList = "latitude, longitude"))
public class ReverseGeocodeResult extends ConvertibleToOpenCageResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private long resultId;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false    )
    private double longitude;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocation result;

    protected ReverseGeocodeResult() {}

    public ReverseGeocodeResult(double latitude, double longitude, GeographicLocation result) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.result = result;
    }

    /**
     * A unique ID representing this reverse geocode result.
     * @return the result ID
     */
    public long getResultId() {
        return resultId;
    }

    /**
     * The latitude that was used in the search for this reverse geocode result.
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * The longitude that was used in the search for this reverse geocode result.
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * The timestamp representing when this reverse geocode result was saved. This is used to decide whether we should update the record.
     * @return The time of creation
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * The resulting geographic location that was saved.
     * @return the geographic location
     */
    public GeographicLocation getResult() {
        return result;
    }

    /**
     * Converts this reverse geocode result to an OpenCageResponse.
     * @return an {@link OpenCageResponse}
     */
    @Override
    public OpenCageResponse convert() {
        return convert0(getResult());
    }

    /**
     * Runs pre-creation tasks
     */
    @PrePersist
    protected void onCreate() {
        created = Timestamp.from(Instant.now());
    }

    @Override
    public String toString() {
        return "ReverseGeocodeResult{" +
                "resultId=" + resultId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", created=" + created +
                ", result=" + result +
                '}';
    }
}
