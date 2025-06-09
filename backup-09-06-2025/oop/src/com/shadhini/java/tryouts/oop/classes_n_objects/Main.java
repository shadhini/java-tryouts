package com.shadhini.java.tryouts.oop.classes_n_objects;

public class Main {

    public static void main(String[] args) {

        // Instantiating TextBox class: Create TextBox object
        var textBox1 = new TextBox();
        textBox1.setText("Box 1"); // -- A
        System.out.println(textBox1.text); // Output: Box 1
        System.out.println(textBox1.text.toUpperCase()); // Output: BOX 1

        // without line A
        System.out.println(textBox1.text); // Output: null
        // System.out.println(textBox1.text.toUpperCase()); // --> java.lang.NullPointerException

        var textBox2 = new TextBox();
        textBox2.setText("Box 2");
        System.out.println(textBox2.text);

    }
}
