package IteratorDesignPattern;

import java.util.List;

public class ListIterator<T> implements Iterator<T> {
    private List<T> collection;
    private int index = 0;

    ListIterator(List<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.size();
    }

    @Override
    public T next() {
        return hasNext() ? collection.get(index++) : null;
    }
}
