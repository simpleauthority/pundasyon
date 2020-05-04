package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.TwitterDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = TwitterDeserializer.class)
public class Twitter {
    private String image;
    private String title;
    private String description;
}
