package com.shadhini.tryouts.java.oop.classes_n_objects;

/**
 * TextBox class.
 */
public class TextBox {
    // TextBox class has 3 members; a field and 2 methods

    public String text; // Field --  usually we don't define fields as public

    public void setText(String text) {
        // this refers to the current instance of the class
        this.text = text;
    }

    public void clear() {
        text = "";
    }

}
