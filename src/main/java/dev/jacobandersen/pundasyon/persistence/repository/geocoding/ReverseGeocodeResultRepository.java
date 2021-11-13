package dev.jacobandersen.pundasyon.persistence.repository.geocoding;

import dev.jacobandersen.pundasyon.persistence.entity.geocoding.ForwardGeocodeResult;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.ReverseGeocodeResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface ReverseGeocodeResultRepository extends CrudRepository<ReverseGeocodeResult, Long> {
    /**
     * Finds a reverse geocode result by the latitude and longitude used to initially retrieve it from OpenCage.
     * @param latitude the latitude
     * @param longitude the longitude
     * @return the reverse geocode result
     */
    @Cacheable(value = "reverse_geocode_results", key="#latitude + ',' + #longitude")
    ReverseGeocodeResult findByLatitudeAndLongitude(double latitude, double longitude);

    /**
     * Saves a {@link ReverseGeocodeResult} to the database.
     * @param result the result to save
     */
    @Override
    @CacheEvict(value = "forward_geocode_results", key="#result?.getLatitude() + ',' + #result?.getLongitude()")
    <S extends ReverseGeocodeResult> S save(S result);
}
