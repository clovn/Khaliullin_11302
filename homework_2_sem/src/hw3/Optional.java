package hw3;

import java.util.Objects;

public class Optional<T> {

    private final T value;

    private Optional(T value) {
        this.value = value;
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(Objects.requireNonNull(value));
    }

    public static <T> Optional<T> empty() {
        return new Optional<>(null);
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }
}

