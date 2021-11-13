package dev.jacobandersen.pundasyon.persistence.entity.geocoding.support;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "geographic_location_metadata")
@AllArgsConstructor
@Builder
public class GeographicLocationMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metadata_id", nullable = false)
    private long metadataId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timezone_metadata_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocationTimezoneMetadata timezoneMetadata;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driving_metadata_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocationDrivingMetadata drivingMetadata;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_metadata_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocationCurrencyMetadata currencyMetadata;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "miscellaneous_metadata_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocationMiscellaneousMetadata miscellaneousMetadata;

    protected GeographicLocationMetadata() {}

    public GeographicLocationMetadata(GeographicLocationDrivingMetadata drivingMetadata, GeographicLocationCurrencyMetadata currencyMetadata, GeographicLocationMiscellaneousMetadata miscellaneousMetadata) {
        this.drivingMetadata = drivingMetadata;
        this.currencyMetadata = currencyMetadata;
        this.miscellaneousMetadata = miscellaneousMetadata;
    }

    /**
     * A unique ID representing this metadata.
     * @return the metadata ID
     */
    public long getMetadataId() {
        return metadataId;
    }

    /**
     * Metadata related to the timezone at the connected location.
     * @return the timezone metadata
     */
    public GeographicLocationTimezoneMetadata getTimezoneMetadata() {
        return timezoneMetadata;
    }

    /**
     * Metadata related to driving at the connected location.
     * @return the driving metadata
     */
    public GeographicLocationDrivingMetadata getDrivingMetadata() {
        return drivingMetadata;
    }

    /**
     * Metadata related to currency used at the connected location.
     * @return the currency metadata
     */
    public GeographicLocationCurrencyMetadata getCurrencyMetadata() {
        return currencyMetadata;
    }

    /**
     * Metadata related to the connected location that could not be easily sorted elsewhere.
     * @return the miscellaneous metadata
     */
    public GeographicLocationMiscellaneousMetadata getMiscellaneousMetadata() {
        return miscellaneousMetadata;
    }

    @Override
    public String toString() {
        return "GeographicLocationMetadata{" +
                "metadataId=" + metadataId +
                ", timezoneMetadata=" + timezoneMetadata +
                ", drivingMetadata=" + drivingMetadata +
                ", currencyMetadata=" + currencyMetadata +
                ", miscellaneousMetadata=" + miscellaneousMetadata +
                '}';
    }
}
