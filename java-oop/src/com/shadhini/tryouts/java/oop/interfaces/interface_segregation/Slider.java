package com.shadhini.tryouts.java.oop.interfaces.interface_segregation;

public class Slider implements UIWidget {

    @Override
    public void drag() {
        System.out.println("Dragging the slider...");
    }

    @Override
    public void resize(int size) {
        System.out.println("Resizing the slider to size: " + size);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("Resizing the slider to width: " + width + " and height: " + height);
    }

    @Override
    public void resize(UIWidget uiWidget) {
        System.out.println("Resizing the slider based on another UIWidget.");
    }

    @Override
    public void render() {
        System.out.println("Rendering the slider.");
    }
}
