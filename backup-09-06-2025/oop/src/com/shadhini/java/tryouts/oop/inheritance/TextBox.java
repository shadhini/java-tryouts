package com.shadhini.java.tryouts.oop.inheritance;

public class TextBox extends UIControl {

    private String text;

    public TextBox() {
        // default constructor
        super(true);
        System.out.println("Text Box created.");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }

}
