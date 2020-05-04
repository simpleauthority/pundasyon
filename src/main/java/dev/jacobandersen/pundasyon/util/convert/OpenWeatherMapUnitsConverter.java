package dev.jacobandersen.pundasyon.util.convert;

import dev.jacobandersen.pundasyon.net.OpenWeatherMapClient;
import dev.jacobandersen.pundasyon.util.EnumUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapUnitsConverter implements Converter<String, OpenWeatherMapClient.OpenWeatherMapUnits> {
    @Override
    public OpenWeatherMapClient.OpenWeatherMapUnits convert(String source) {
        return EnumUtil.fromString(OpenWeatherMapClient.OpenWeatherMapUnits.class, source);
    }
}
