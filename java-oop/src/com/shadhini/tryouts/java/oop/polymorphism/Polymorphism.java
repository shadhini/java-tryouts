package com.shadhini.tryouts.java.oop.polymorphism;

/**
 * Demonstration of Polymorphism.
 */
public class Polymorphism {

    public static void demo() {

        // We can have different types of ui control objects in a one array and render them
        // without having if else clauses for each control type (e.g: TextBox, CheckBox)
        UIControl[] controls = {new TextBox(), new CheckBox()};

        for (UIControl control : controls)
            control.render(); // Polymorphism in action
            // This control object is taking many different forms, and
            // they are calling their own render() method at runtime

    }
}
