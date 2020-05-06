package dev.jacobandersen.pundasyon.svc;

import dev.jacobandersen.pundasyon.net.OpenCageClient;
import dev.jacobandersen.pundasyon.obj.OpenCageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenCageService {
    private final OpenCageClient client;

    @Autowired
    public OpenCageService(OpenCageClient client) {
        this.client = client;
    }

    public OpenCageResponse getForwardGeocode(String place) {
        return client.getForwardGeocode(place).getBody();
    }

    public OpenCageResponse getReverseGeocode(float latitude, float longitude) {
        return client.getReverseGeocode(latitude, longitude).getBody();
    }
}
