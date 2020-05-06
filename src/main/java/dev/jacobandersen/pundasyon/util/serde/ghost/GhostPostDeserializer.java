package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostAuthor;
import dev.jacobandersen.pundasyon.obj.ghost.GhostPost;
import dev.jacobandersen.pundasyon.obj.ghost.support.*;

import java.io.IOException;
import java.util.List;

public class GhostPostDeserializer extends StdDeserializer<GhostPost> {
    public GhostPostDeserializer() {
        super(GhostPost.class);
    }

    @Override
    public GhostPost deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        GhostAuthor primaryAuthor = tree.get("primary_author").traverse(p.getCodec()).readValueAs(GhostAuthor.class);
        List<GhostAuthor> authors = tree.get("authors").traverse(p.getCodec()).readValueAs(new TypeReference<List<GhostAuthor>>() {
        });
        Content content = tree.traverse(p.getCodec()).readValueAs(Content.class);
        Dates dates = tree.traverse(p.getCodec()).readValueAs(Dates.class);
        CodeInjection codeInjection = tree.traverse(p.getCodec()).readValueAs(CodeInjection.class);
        OpenGraph openGraph = tree.traverse(p.getCodec()).readValueAs(OpenGraph.class);
        Twitter twitter = tree.traverse(p.getCodec()).readValueAs(Twitter.class);
        Meta meta = tree.traverse(p.getCodec()).readValueAs(Meta.class);

        return GhostPost.builder()
                .author(GhostPost.Author.builder()
                        .primary(primaryAuthor)
                        .all(authors)
                        .build())
                .content(content)
                .misc(GhostPost.Misc.builder()
                        .featureImage(tree.get("feature_image").asText(""))
                        .readingTime(tree.get("reading_time").asInt(0))
                        .build())
                .dates(dates)
                .codeInjection(codeInjection)
                .openGraph(openGraph)
                .twitter(twitter)
                .meta(meta)
                .build();
    }
}
