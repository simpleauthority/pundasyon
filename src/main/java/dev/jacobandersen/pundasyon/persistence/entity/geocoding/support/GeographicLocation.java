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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "geographic_location")
@AllArgsConstructor
@Builder
public class GeographicLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private long locationId;

    @Column(name = "continent")
    private String continent;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "region")
    private String region;

    @Column(name = "city")
    private String city;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bound_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicBound bound;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "metadata_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private GeographicLocationMetadata metadata;

    protected GeographicLocation() {}

    public GeographicLocation(String continent, String country, String state, String region, String city, double latitude, double longitude, GeographicBound bound, GeographicLocationMetadata metadata) {
        this.continent = continent;
        this.country = country;
        this.state = state;
        this.region = region;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bound = bound;
        this.metadata = metadata;
    }

    /**
     * A unique ID representing this geographic location.
     * @return the location ID
     */
    public long getLocationId() {
        return locationId;
    }

    /**
     * The continent where this location is found.
     * @return the continent name
     */
    public String getContinent() {
        return continent;
    }

    /**
     * The country where this location is found.
     * @return the country name
     */
    public String getCountry() {
        return country;
    }

    /**
     * The state where this location is found.
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * The region where this location is found.
     * @return the region name
     */
    public String getRegion() {
        return region;
    }

    /**
     * The city where this location is found.
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * The latitude of this location.
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * The longitude of this location.
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the geographic bound that contains this location.
     * @return the bound
     */
    public GeographicBound getBound() {
        return bound;
    }

    /**
     * Gets the metadata that provides further contextual information about this location.
     * @return the metadata
     */
    public GeographicLocationMetadata getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "GeographicLocation{" +
                "locationId=" + locationId +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", bound=" + bound +
                ", metadata=" + metadata +
                '}';
    }
}
