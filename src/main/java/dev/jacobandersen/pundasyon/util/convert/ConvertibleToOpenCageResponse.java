package dev.jacobandersen.pundasyon.util.convert;

import dev.jacobandersen.pundasyon.object.opencage.OpenCageGeography;
import dev.jacobandersen.pundasyon.object.opencage.OpenCageMetadata;
import dev.jacobandersen.pundasyon.object.opencage.OpenCageResponse;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicBound;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocation;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocationCurrencyMetadata;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocationDrivingMetadata;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocationMetadata;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocationMiscellaneousMetadata;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.support.GeographicLocationTimezoneMetadata;

public abstract class ConvertibleToOpenCageResponse implements Convertible<GeographicLocation, OpenCageResponse> {
    public abstract OpenCageResponse convert();

    @Override
    public final OpenCageResponse convert0(GeographicLocation location) {
        GeographicBound bound = location.getBound();
        GeographicLocationMetadata metadata = location.getMetadata();
        GeographicLocationTimezoneMetadata tzMeta = metadata.getTimezoneMetadata();
        GeographicLocationDrivingMetadata drivingMeta = metadata.getDrivingMetadata();
        GeographicLocationCurrencyMetadata currencyMeta = metadata.getCurrencyMetadata();
        GeographicLocationMiscellaneousMetadata miscMeta = metadata.getMiscellaneousMetadata();

        return OpenCageResponse.builder()
                .source(OpenCageResponse.Source.DATABASE)
                .geography(OpenCageGeography.builder()
                        .place(OpenCageGeography.Place.builder()
                                .latitude(location.getLatitude())
                                .longitude(location.getLongitude())
                                .continent(location.getContinent())
                                .country(location.getCountry())
                                .state(location.getState())
                                .region(location.getRegion())
                                .city(location.getCity())
                                .build())
                        .northeastBound(OpenCageGeography.Bound.builder()
                                .latitude(bound.getNortheastLatitude())
                                .longitude(bound.getNortheastLongitude())
                                .build())
                        .southwestBound(OpenCageGeography.Bound.builder()
                                .latitude(bound.getSouthwestLatitude())
                                .longitude(bound.getSouthwestLongitude())
                                .build())
                        .build())
                .metadata(OpenCageMetadata.builder()
                        .timezone(OpenCageMetadata.Timezone.builder()
                                .name(tzMeta.getName())
                                .shortName(tzMeta.getShortName())
                                .inDaylightSavings(tzMeta.isInDaylightSavings())
                                .offsetFromUtc(tzMeta.getOffsetFromUtc())
                                .build())
                        .driving(OpenCageMetadata.Driving.builder()
                                .sideOfRoad(drivingMeta.getSideOfRoad())
                                .unitsOfSpeed(drivingMeta.getUnitsOfSpeed())
                                .build())
                        .currency(OpenCageMetadata.Currency.builder()
                                .name(currencyMeta.getName())
                                .symbol(currencyMeta.getSymbol())
                                .unambiguousSymbol(currencyMeta.getUnambiguousSymbol())
                                .placeSymbolFirst(currencyMeta.isPlaceSymbolFirst())
                                .decimalMark(currencyMeta.getDecimalMark())
                                .thousandsSeparator(currencyMeta.getThousandsSeparator())
                                .smallestDenomination(currencyMeta.getSmallestDenomination())
                                .subunitName(currencyMeta.getSubunitName())
                                .subunitsInUnit(currencyMeta.getSubunitToUnit())
                                .build())
                        .miscellaneous(OpenCageMetadata.Miscellaneous.builder()
                                .flag(miscMeta.getFlag())
                                .callingCode(miscMeta.getCallingCode())
                                .qibla(miscMeta.getQibla())
                                .build())
                        .build())
                .build();
    }
}
