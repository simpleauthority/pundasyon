package dev.jacobandersen.pundasyon.util;

import com.fasterxml.jackson.databind.JsonNode;

public class ConditionalUtil {
    public static boolean hasJsonStructure(JsonNode node, String... properties) {
        for (String property : properties) {
            if (property.contains(".")) {
                String[] pieces = property.split("\\.");

                JsonNode path = node;
                for (int i = 0; i < pieces.length - 1; i++) {
                    path = path.get(pieces[i]);
                }

                if (!path.has(pieces[pieces.length - 1])) return false;
            } else {
                if (!node.has(property)) return false;
            }
        }

        return true;
    }
}
