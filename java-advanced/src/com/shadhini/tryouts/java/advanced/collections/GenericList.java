package com.shadhini.tryouts.java.advanced.collections;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {
    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        // Here we are creating a ListIterator for the current GenericList.
        return new ListIterator(this);
    }

    // The `T` we define here in Iterator<T> is the same `T` we used in GenericList<T>
    // Since we want to iterate over the same type parameter as declared on top
    private class ListIterator implements Iterator<T> {

        //Here we want to iterate over a GenericList<T>; so it should be passed to the constructor
        private GenericList<T> list;
        private int index;

        public ListIterator(GenericList<T> list) {
            this.list = list;
            // `list.items` is accessible here: it's okay since, this class is part of implementation of a GenericList<T>
            // Since these details are not exposed to outside
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
