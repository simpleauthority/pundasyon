package dev.jacobandersen.pundasyon.obj.ghost.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serde.ghost.support.DatesDeserializer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonDeserialize(using = DatesDeserializer.class)
public class Dates {
    private Date created;
    private Date published;
    private Date updated;
}
