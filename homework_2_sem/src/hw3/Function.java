package hw3;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T operand);
}
