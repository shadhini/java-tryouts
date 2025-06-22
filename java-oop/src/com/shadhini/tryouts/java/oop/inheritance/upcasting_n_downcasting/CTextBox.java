package com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting;

public class CTextBox extends CUIControl {

    private String text;

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
