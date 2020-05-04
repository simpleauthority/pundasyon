package dev.jacobandersen.pundasyon.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    /**
     * Create a basic String<->String map from a list of entries.
     * <p>The length of the list of entries should be evenly divisible by two such that every key would map to one value.</p>
     *
     * @param entries the list of entries
     * @return the created Map
     */
    public static Map<String, String> createMap(Object... entries) {
        if (entries.length % 2 != 0) {
            throw new IllegalArgumentException("Entries must be evenly divisible by 2.");
        }

        Map<String, String> out = new HashMap<>();
        for (int i = 0; i < entries.length; i += 2) {
            out.put(entries[i].toString(), entries[i + 1].toString());
        }

        return out;
    }
}
