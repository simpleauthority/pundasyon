package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.OpenGraphDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(using = OpenGraphDeserializer.class)
public class OpenGraph {
    private String image;
    private String title;
    private String description;
}
