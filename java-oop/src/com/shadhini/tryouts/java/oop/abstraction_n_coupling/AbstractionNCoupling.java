package com.shadhini.tryouts.java.oop.abstraction_n_coupling;

/**
 * Demonstration of coupling.
 */
public class AbstractionNCoupling {

    // Main class is dependent on the Browser class
    // Main class has 2 coupling points to the Browser class
    public static void demo() {
        var browser = new Browser(); // First coupling point
        browser.navigate("http://www.google.com");

    }
}
