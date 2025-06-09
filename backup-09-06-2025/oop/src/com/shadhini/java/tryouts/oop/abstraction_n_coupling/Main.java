package com.shadhini.java.tryouts.oop.abstraction_n_coupling;

/**
 * Demonstration of coupling.
 */
public class Main {

    // Main class is dependent on the Browser class
    // Main class has 2 coupling points to the Browser class
    public static void main(String[] args) {
        var browser = new Browser(); // First coupling point
        browser.navigate("http://www.google.com");

    }
}
