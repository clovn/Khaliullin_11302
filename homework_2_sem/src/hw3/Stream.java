package hw3;

import java.util.Optional;
import java.util.*;

public class Stream<T> {
    protected List<T> elements;

    public Stream(List<T> arr){
        elements = arr;
    }

    public <R> Stream<R> map(Function<T, R> mapper){
        List<R> mapped = new ArrayList<>();
        for(T el : elements){
            mapped.add(mapper.apply(el));
        }
        return new Stream<>(mapped);
    }

    public <R> Stream<R> flatMap(Function<T, Stream<R>> mapper){
        List<R> mapped = new ArrayList<>();
        for(T el : elements){
            Stream<R> tmp = mapper.apply(el);
            tmp.forEach(mapped::add);
        }

        return new Stream<>(mapped);
    }

    public Stream<T> filter(Predicate<T> predicate){
        List<T> filtered = new ArrayList<>();
        for (T el : elements) {
            if (predicate.filter(el)) filtered.add(el);
        }

        return new Stream<>(filtered);
    }

    public Stream<T> peek(Consumer<T> action){
        for (T el : elements) {
            action.accept(el);
        }
        return this;
    }

    public void forEach(Consumer<T> action){
        for (T element : elements) {
            action.accept(element);
        }
    }

    public IntStream mapToInt(ToIntFunction<T> mapper){
        List<Integer> arr = new ArrayList<>();
        for(T el : elements){
            arr.add(mapper.applyAsInt(el));
        }

        return new IntStream(arr);
    }

    public java.util.Optional<T> findAny(){
        if (elements.isEmpty()) {
            return java.util.Optional.empty();
        } else {
            return Optional.of(elements.get(0));
        }
    }

    public int count(){
        return elements.size();
    }


    public List<T> toList(){
        return elements;
    }

    public Set<T> toSet(){
        return new HashSet<>(elements);
    }
}
