package hw3;

@FunctionalInterface
public interface ToIntFunction<T> {
    int applyAsInt(T value);
}
