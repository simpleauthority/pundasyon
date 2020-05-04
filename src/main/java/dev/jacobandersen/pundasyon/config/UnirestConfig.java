package dev.jacobandersen.pundasyon.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import javax.annotation.PostConstruct;

@Configuration
public class UnirestConfig {
    private final com.fasterxml.jackson.databind.ObjectMapper mapper;

    @Autowired
    public UnirestConfig(com.fasterxml.jackson.databind.ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void postConstruct() {
        Unirest.config()
                .addDefaultHeader("User-Agent", "Pundasyon 1.0.0-SNAPSHOT")
                .addDefaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
                .setObjectMapper(new ObjectMapper() {
                    @Override
                    public <T> T readValue(String value, Class<T> valueType) {
                        try {
                            return mapper.readValue(value, valueType);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public String writeValue(Object value) {
                        try {
                            return mapper.writeValueAsString(value);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }
}
