package com.shadhini.java.tryouts.oop.inheritance;

public class TextBox2 extends UIControl {

    private String text;

    public TextBox2() {
        // default constructor
        super(true);
        System.out.println("Text Box2 created.");
    }

    @Override // Annotation: With this we are telling the Java compiler that
    // we are overriding toString() method declared in the Object class.
    // With this annotation Java Compiler will make sure that this method has the exact same signature as the inherited method.
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }

}
