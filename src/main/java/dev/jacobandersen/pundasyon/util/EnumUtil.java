package dev.jacobandersen.pundasyon.util;

import java.util.Arrays;
import java.util.Locale;

public class EnumUtil {
    public static <T extends Enum<?>> T fromString(Class<T> type, String string) {
        return Arrays.stream(type.getEnumConstants()).filter(entry -> entry.name().equalsIgnoreCase(string)).findFirst().orElse(null);
    }

    public static <T extends Enum<?>> String toString(T value) {
        return toString(value, " ");
    }

    public static <T extends Enum<?>> String toString(T value, String delimeter) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(value.name().split("_")).forEach(part -> builder.append(part.substring(0, 1).toUpperCase(Locale.ROOT)).append(part.substring(1).toLowerCase(Locale.ROOT)).append(delimeter));
        return builder.substring(0, builder.length() - 1);
    }
}
