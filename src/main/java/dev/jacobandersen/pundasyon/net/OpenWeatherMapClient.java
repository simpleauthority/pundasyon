package dev.jacobandersen.pundasyon.net;

import dev.jacobandersen.pundasyon.obj.openweathermap.OpenWeatherMapResponse;
import dev.jacobandersen.pundasyon.util.MapUtil;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OpenWeatherMapClient extends BasicHttpClient {
    @Autowired
    public OpenWeatherMapClient(@Value("${api.openweathermap.url}") String url, @Value("${api.openweathermap.key}") String key) {
        super(url, MapUtil.createMap("appid", key));
    }

    public HttpResponse<OpenWeatherMapResponse> getWeather(float latitude, float longitude, OpenWeatherMapUnits units) {
        Map<String, String> params = MapUtil.createMap(
                "lat", latitude,
                "lon", longitude,
                "exclude", "minutely"
        );

        if (units != OpenWeatherMapUnits.STANDARD) {
            params.put("units", units.toString());
        }

        return get(OpenWeatherMapResponse.class, params, null);
    }

    public enum OpenWeatherMapUnits {
        STANDARD,
        IMPERIAL,
        METRIC;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
}
