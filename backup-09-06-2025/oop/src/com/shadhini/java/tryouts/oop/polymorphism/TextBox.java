package com.shadhini.java.tryouts.oop.polymorphism;

public class TextBox extends UIControl {

    private String text;

    public TextBox() {
        // default constructor
        super(true);
        System.out.println("Text Box created.");
    }

    @Override
    public void render() {
        System.out.println("Text Box rendered.");
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
