package dev.jacobandersen.pundasyon.util.serde.ghost;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.jacobandersen.pundasyon.obj.ghost.GhostInfo;
import dev.jacobandersen.pundasyon.obj.ghost.support.CodeInjection;
import dev.jacobandersen.pundasyon.obj.ghost.support.Meta;
import dev.jacobandersen.pundasyon.obj.ghost.support.OpenGraph;
import dev.jacobandersen.pundasyon.obj.ghost.support.Twitter;

import java.io.IOException;

public class GhostInfoDeserializer extends StdDeserializer<GhostInfo> {
    public GhostInfoDeserializer() {
        super(GhostInfo.class);
    }

    @Override
    public GhostInfo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();

        JsonNode settings = tree.get("settings");
        Meta meta = settings.traverse(p.getCodec()).readValueAs(Meta.class);
        OpenGraph openGraph = settings.traverse(p.getCodec()).readValueAs(OpenGraph.class);
        Twitter twitter = settings.traverse(p.getCodec()).readValueAs(Twitter.class);
        CodeInjection codeInjection = settings.traverse(p.getCodec()).readValueAs(CodeInjection.class);

        return GhostInfo.builder()
                .title(settings.get("title").asText(""))
                .description(settings.get("description").asText(""))
                .images(GhostInfo.Images.builder()
                        .logo(settings.get("logo").asText(""))
                        .icon(settings.get("icon").asText(""))
                        .coverImage(settings.get("cover_image").asText(""))
                        .build())
                .social(GhostInfo.Social.builder()
                        .facebook(settings.get("facebook").asText(""))
                        .twitter(settings.get("twitter").asText(""))
                        .build())
                .lang(settings.get("lang").asText(""))
                .timezone(settings.get("timezone").asText(""))
                .meta(meta)
                .openGraph(openGraph)
                .twitter(twitter)
                .codeInjection(codeInjection)
                .build();
    }
}
