package hw2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MyHashMap<K, V> {
    List<Pair<K, V>>[] map = new ArrayList[64];

    public void put (K key, V value){
        int hashCode = Math.abs(key.hashCode() % 64);
        if(map[hashCode] == null){
            map[hashCode] = new ArrayList<>();
        } else {
            for(Pair<K, V> el : map[hashCode]){
                if(el.getKey().equals(key)) el.setValue(value);
            }
        }
        map[hashCode].add(new Pair<>(key, value));
    }

    public boolean containsKey(K key){
        int hashcode = Math.abs(key.hashCode() % 64);
        if(map[hashcode] == null) return false;
        for(Pair<K, V> el : map[hashcode]){
            if(el.getKey().equals(key)) return true;
        }

        return false;
    }

    public boolean containsValue(V value){

        for(List<Pair<K, V>> list : map){
            if(list == null) continue;
            for(Pair<K, V> el : list){
                if(el.getValue().equals(value)) return true;
            }
        }

        return false;
    }

    public void remove (K key){
        int hashCode = Math.abs(key.hashCode() % 64);
        for(Pair<K, V> el : map[hashCode]){
            if(el.getKey() == key) map[hashCode].remove(el);
            return;
        }
    }

    public V get(K key){
        int hashCode = Math.abs(key.hashCode() % 64);
        for(Pair<K, V> el : map[hashCode]){
            if(el.getKey().equals(key)) return el.getValue();
        }
        throw new NoSuchElementException("Doesn't exist");
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "map=" + Arrays.toString(map) +
                '}';
    }
}

class Pair<K, V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }


    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}
