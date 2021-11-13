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

public abstract class ConvertibleToGeographicLocation implements Convertible<OpenCageResponse, GeographicLocation> {
    public abstract GeographicLocation convert();

    @Override
    public final GeographicLocation convert0(OpenCageResponse location) {
        OpenCageGeography geography = location.getGeography();
        OpenCageGeography.Place place = geography.getPlace();
        OpenCageGeography.Bound neBound = geography.getNortheastBound(), swBound = geography.getSouthwestBound();
        OpenCageMetadata meta = location.getMetadata();
        OpenCageMetadata.Timezone tzMeta = meta.getTimezone();
        OpenCageMetadata.Driving drivingMeta = meta.getDriving();
        OpenCageMetadata.Currency currencyMeta = meta.getCurrency();
        OpenCageMetadata.Miscellaneous miscMeta = meta.getMiscellaneous();

        return GeographicLocation.builder()
                .continent(place.getContinent())
                .country(place.getCountry())
                .state(place.getState())
                .region(place.getRegion())
                .city(place.getCity())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .bound(GeographicBound.builder()
                        .northeastLatitude(neBound.getLatitude())
                        .northeastLongitude(neBound.getLongitude())
                        .southwestLatitude(swBound.getLatitude())
                        .southwestLongitude(swBound.getLongitude())
                        .build())
                .metadata(GeographicLocationMetadata.builder()
                        .timezoneMetadata(GeographicLocationTimezoneMetadata.builder()
                                .name(tzMeta.getName())
                                .shortName(tzMeta.getShortName())
                                .inDaylightSavings(tzMeta.isInDaylightSavings())
                                .offsetFromUtc(tzMeta.getOffsetFromUtc())
                                .build())
                        .drivingMetadata(GeographicLocationDrivingMetadata.builder()
                                .sideOfRoad(drivingMeta.getSideOfRoad())
                                .unitsOfSpeed(drivingMeta.getUnitsOfSpeed())
                                .build())
                        .currencyMetadata(GeographicLocationCurrencyMetadata.builder()
                                .name(currencyMeta.getName())
                                .symbol(currencyMeta.getSymbol())
                                .unambiguousSymbol(currencyMeta.getUnambiguousSymbol())
                                .placeSymbolFirst(currencyMeta.isPlaceSymbolFirst())
                                .decimalMark(currencyMeta.getDecimalMark())
                                .thousandsSeparator(currencyMeta.getThousandsSeparator())
                                .smallestDenomination(currencyMeta.getSmallestDenomination())
                                .subunitName(currencyMeta.getSubunitName())
                                .subunitToUnit(currencyMeta.getSubunitsInUnit())
                                .build())
                        .miscellaneousMetadata(GeographicLocationMiscellaneousMetadata.builder()
                                .flag(miscMeta.getFlag())
                                .callingCode(miscMeta.getCallingCode())
                                .qibla(miscMeta.getQibla())
                                .build())
                        .build())
                .build();
    }
}
