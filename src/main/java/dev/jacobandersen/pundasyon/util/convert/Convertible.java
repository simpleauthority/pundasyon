package dev.jacobandersen.pundasyon.util.convert;

public interface Convertible<IN, OUT> {
    OUT convert();
    OUT convert0(IN in);
}
