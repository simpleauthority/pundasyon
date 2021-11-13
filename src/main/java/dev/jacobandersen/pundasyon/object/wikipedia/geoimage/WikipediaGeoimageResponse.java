package dev.jacobandersen.pundasyon.object.wikipedia.geoimage;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.jacobandersen.pundasyon.util.serialization.WikipediaGeoimageResponseDeserializer;
import lombok.Data;

import java.util.List;

@Data
@JsonDeserialize(using = WikipediaGeoimageResponseDeserializer.class)
public class WikipediaGeoimageResponse {
    private List<WikipediaGeoimageMatch> matches;

    public WikipediaGeoimageResponse(List<WikipediaGeoimageMatch> matches) {
        this.matches = matches;
    }
}
