package com.shadhini.java.tryouts.class_loading;

public class MyClass {

    static {
        System.out.println("MyClass static block initialized");
    }

    public static void printMessage() {
        System.out.println("Hello from MyClass");
    }

}
