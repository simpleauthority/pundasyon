package dev.jacobandersen.pundasyon.util;

import java.util.Arrays;

public class EnumUtil {
    public static <T extends Enum<?>> T fromString(Class<T> type, String string) {
        return Arrays.stream(type.getEnumConstants()).filter(entry -> entry.name().equalsIgnoreCase(string)).findFirst().orElse(null);
    }
}
