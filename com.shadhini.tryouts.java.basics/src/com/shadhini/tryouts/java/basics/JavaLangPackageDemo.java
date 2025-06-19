package com.shadhini.tryouts.java.basics;

import java.io.IOException;

/**
 * Demonstrate usage of `java.lang` package.
 */
public class JavaLangPackageDemo {

    // no need for explicit import
    public static void demo() {
        // `System` class of `java.lang` package -----------------------------------------------------------------------
        System.out.println("Hello, World!"); // out field: prints to terminal
        // System.out.println method: calls toString() method of the object passed to it
        try {
            System.out.println(System.in.available());  // in field: read from terminal
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
