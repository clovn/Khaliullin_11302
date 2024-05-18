package hw3;

@FunctionalInterface
public interface Predicate<T> {
    boolean filter(T operand);
}
