package dev.jacobandersen.pundasyon.persistence.entity.geocoding.support;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geographic_location_miscellaneous_metadata")
@AllArgsConstructor
@Builder
public class GeographicLocationMiscellaneousMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "miscellaneous_metadata_id", nullable = false)
    private long miscellaneousMetadataId;

    @Column(name = "flag")
    private String flag;

    @Column(name = "calling_code")
    private int callingCode;

    @Column(name = "qibla")
    private float qibla;

    protected GeographicLocationMiscellaneousMetadata() {}

    public GeographicLocationMiscellaneousMetadata(String flag, int callingCode, float qibla) {
        this.flag = flag;
        this.callingCode = callingCode;
        this.qibla = qibla;
    }

    /**
     * A unique ID representing this miscellaneous metadata.
     * @return the miscellaneous metadata ID
     */
    public long getMiscellaneousMetadataId() {
        return miscellaneousMetadataId;
    }

    /**
     * Gets the flag that represents the connected location.
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Gets the calling code prefix for international callers to reach the connected location.
     * @return the calling code
     */
    public int getCallingCode() {
        return callingCode;
    }

    /**
     * Gets the degrees from true North one must turn in order to face the Kaaba for prayer in the Islamic religion.
     * @return direction to turn to face the Kaaba
     */
    public float getQibla() {
        return qibla;
    }

    @Override
    public String toString() {
        return "GeographicLocationMiscellaneousMetadata{" +
                "miscellaneousMetadataId=" + miscellaneousMetadataId +
                ", flag='" + flag + '\'' +
                ", callingCode=" + callingCode +
                ", qibla=" + qibla +
                '}';
    }
}
