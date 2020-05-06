package dev.jacobandersen.pundasyon.util;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static String glueWithFormatOnComma(List<String> list, String format) {
        return glueWithFormatAndDelimiter(list, format, ",");
    }

    public static String glueWithFormatAndDelimiter(List<String> list, String format, String delimiter) {
        return list.stream().map(item -> String.format(format, item)).collect(Collectors.joining(delimiter));
    }
}
