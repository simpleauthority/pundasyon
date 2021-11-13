package dev.jacobandersen.pundasyon.service;

import dev.jacobandersen.pundasyon.persistence.entity.geocoding.ForwardGeocodeResult;
import dev.jacobandersen.pundasyon.persistence.entity.geocoding.ReverseGeocodeResult;
import dev.jacobandersen.pundasyon.persistence.repository.geocoding.ForwardGeocodeResultRepository;
import dev.jacobandersen.pundasyon.persistence.repository.geocoding.ReverseGeocodeResultRepository;
import dev.jacobandersen.pundasyon.net.upstream.OpenCageClient;
import dev.jacobandersen.pundasyon.object.opencage.OpenCageResponse;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenCageService {
    private final OpenCageClient client;
    private final ForwardGeocodeResultRepository forwardGeocodeResultRepository;
    private final ReverseGeocodeResultRepository reverseGeocodeResultRepository;

    @Autowired
    public OpenCageService(OpenCageClient client, ForwardGeocodeResultRepository forwardGeocodeResultRepository, ReverseGeocodeResultRepository reverseGeocodeResultRepository) {
        this.client = client;
        this.forwardGeocodeResultRepository = forwardGeocodeResultRepository;
        this.reverseGeocodeResultRepository = reverseGeocodeResultRepository;
    }

    public OpenCageResponse getForwardGeocode(String query) {
        ForwardGeocodeResult saved = forwardGeocodeResultRepository.findByQuery(query);
        if (saved != null) {
            return saved.convert();
        } else {
            HttpResponse<OpenCageResponse> resp = client.getForwardGeocode(query);
            resp.getParsingError().ifPresent(err -> {
                err.printStackTrace();
                System.err.println(err.getOriginalBody());
            });

            OpenCageResponse body = resp.getBody();
            if (body != null) {
                forwardGeocodeResultRepository.save(new ForwardGeocodeResult(query, body.convert()));
            }

            return body;
        }
    }

    public OpenCageResponse getReverseGeocode(float latitude, float longitude) {
        ReverseGeocodeResult saved = reverseGeocodeResultRepository.findByLatitudeAndLongitude(latitude, longitude);
        if (saved != null) {
            return saved.convert();
        } else {
            HttpResponse<OpenCageResponse> resp = client.getReverseGeocode(latitude, longitude);
            resp.getParsingError().ifPresent(err -> {
                err.printStackTrace();
                System.err.println(err.getOriginalBody());
            });

            OpenCageResponse body = resp.getBody();
            if (body != null) {
                reverseGeocodeResultRepository.save(new ReverseGeocodeResult(latitude, longitude, body.convert()));
            }

            return body;
        }
    }
}
