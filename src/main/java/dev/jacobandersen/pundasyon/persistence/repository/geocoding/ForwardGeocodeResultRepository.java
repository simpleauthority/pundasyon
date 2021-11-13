package dev.jacobandersen.pundasyon.persistence.repository.geocoding;

import dev.jacobandersen.pundasyon.persistence.entity.geocoding.ForwardGeocodeResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;

public interface ForwardGeocodeResultRepository extends CrudRepository<ForwardGeocodeResult, Long> {
    /**
     * Finds a forward geocode result by the query used to initially retrieve it from OpenCage.
     * @param query the query
     * @return the forward geocode result
     */
    @Cacheable(value = "forward_geocode_results", key="#query")
    ForwardGeocodeResult findByQuery(String query);

    /**
     * Saves a {@link ForwardGeocodeResult} to the database.
     * @param result the result to save
     */
    @Override
    @CacheEvict(value = "forward_geocode_results", key="#result?.getQuery()")
    <S extends ForwardGeocodeResult> S save(S result);
}
