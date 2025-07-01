package com.shadhini.tryouts.java.advanced.generics;

// To store different types of Obects that are Comparable and Cloneable
// T: Type Parameter
public class ComparableCloneableGenericList<T extends Comparable & Cloneable> { // Genric Class with Multiple Constraints

    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) { // Generic Method
        items[count++] = item;
    }

    public T get(int index) { // Generic Method
        return items[index];
    }
}
