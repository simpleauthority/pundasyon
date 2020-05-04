package dev.jacobandersen.pundasyon.net;

import dev.jacobandersen.pundasyon.obj.OpenCageResponse;
import dev.jacobandersen.pundasyon.util.MapUtil;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenCageClient extends BasicHttpClient {
    public OpenCageClient(@Value("${api.opencage.url}") String url, @Value("${api.opencage.key}") String key) {
        super(url, MapUtil.createMap("key", key));
    }

    public HttpResponse<OpenCageResponse> getForwardGeocode(String place) {
        return get(OpenCageResponse.class, MapUtil.createMap("q", place), null);
    }

    public HttpResponse<OpenCageResponse> getReverseGeocode(float latitude, float longitude) {
        return get(OpenCageResponse.class, MapUtil.createMap("q", String.format("%s+%s", latitude, longitude)), null);
    }
}
