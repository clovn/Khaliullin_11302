package hw2;

import java.util.Arrays;

public class MyList<T> {

    private T[] array;
    private int size;
    private int capacity;

    public MyList(int capacity){
        this.size = 0;
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void add(T el) {
        if(size < capacity) {
            array[size] = el;
            size++;
        } else {
            growArray();
            add(el);
        }
    }


    public T get(int index) {
        return array[index];
    }

    public int getIndex(T value){
        for(int i = 0; i < size; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return getIndex(element) != -1;
    }

    private void growArray() {
        int newCapacity = array.length + 20;
        array = Arrays.copyOf(array, newCapacity);
    }

    public void remove(T element) {
        int index = getIndex(element);
        if (index != -1) {
            removeAtIndex(index);
        }
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    public T[] toArray(){
        return Arrays.copyOf(array, size);
    }

//    public int
}
