package com.shadhini.tryouts.java.advanced.generics.poor_implementation;

import com.shadhini.tryouts.java.advanced.generics.User;

/**
 * Poor implementation of a List-like structure that does not use generics.
 */
public class PoorImplementationOfListDemo {

    public static void demo() {

        var list = new List();
        list.add(1);
        list.add("2");
        list.add(new TUser());

        int value = (int) list.get(0);
        int value2 = (int) list.get(1); // --> ClassCastException


    }
}
