package com.shadhini.tryouts.java.advanced.generics;

// To store different types of Numbers
// T: Type Parameter
public class GenericList<T> { // Generic Class

    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) { // Generic Method
        items[count++] = item;
    }

    public T get(int index) { // Generic Method
        return items[index];
    }
}
