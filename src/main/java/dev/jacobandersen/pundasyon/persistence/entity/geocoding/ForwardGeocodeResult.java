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
@Table(name = "forward_geocode_result", indexes = @Index(name="queryIdx", columnList = "query"))
public class ForwardGeocodeResult extends ConvertibleToOpenCageResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private long resultId;

    @Column(name = "query", nullable = false)
    private String query;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocation result;

    protected ForwardGeocodeResult() {}

    public ForwardGeocodeResult(String query, GeographicLocation result) {
        this.query = query;
        this.result = result;
    }

    /**
     * A unique ID representing this forward geocode result.
     * @return the result ID
     */
    public long getResultId() {
        return resultId;
    }

    /**
     * The search query that was used when obtaining this forward geocode result.
     * @return the search query text
     */
    public String getQuery() {
        return query;
    }

    /**
     * The timestamp representing when this forward geocode result was saved. This is used to decide whether we should update the record.
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
     * Converts this forward geocode result to an OpenCageResponse.
     * @return an {@link OpenCageResponse}
     */
    @Override
    public final OpenCageResponse convert() {
        return convert0(getResult());
    }

    /**
     * Runs pre-creation tasks
     */
    @PrePersist
    protected final void onCreate() {
        created = Timestamp.from(Instant.now());
    }

    @Override
    public String toString() {
        return "ForwardGeocodeResult{" +
                "resultId=" + resultId +
                ", query='" + query + '\'' +
                ", created=" + created +
                ", result=" + result +
                '}';
    }
}
