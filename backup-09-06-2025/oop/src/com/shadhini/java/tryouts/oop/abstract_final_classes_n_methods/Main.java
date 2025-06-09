package com.shadhini.java.tryouts.oop.abstract_final_classes_n_methods;

public class Main {

    public static void main(String[] args) {
        // Here UIControl is an abstract concept.
        // We can't add an implementation to the render method in UIControl since it's an abstract thing.
        // The whole purpose of the UIControl class is
        //      to provide some common behaviour for subclasses like TextBoxes CheckBoxes.

        UIControl[] controls = {new TextBox(), new CheckBox()};

        for (UIControl control : controls)
            control.render();

    }
}
