package HashMap;

import java.security.Key;
import java.util.LinkedList;

class Element<K, V> {
    K key;
    V value;
    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


public class HashMap<K, V> {
    int size = 16;
    LinkedList<Element<K, V>>[] list;
    public HashMap() {

    }

    public HashMap(int size) {
        this.size = size;
        list = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            list[i] = new LinkedList<Element<K, V>>();
        }
    }

    public void put(K key, V value) {
        int index = key.hashCode() % size;
        LinkedList<Element<K, V>> listAtIndex = list[index];
        for (Element<K, V> e: listAtIndex) {
            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }
        }
        Element<K, V> element = new Element<>(key, value);
        listAtIndex.add(element);
    }

    public V get(K key) throws IllegalArgumentException {
        int index = key.hashCode() % size;
        LinkedList<Element<K, V>> listAtIndex = list[index];
        for (Element<K, V> e: listAtIndex) {
            if (e.getKey() == key) {
               return e.getValue();
            }
        }

        throw new IllegalArgumentException("No value with this key");
    }
}
