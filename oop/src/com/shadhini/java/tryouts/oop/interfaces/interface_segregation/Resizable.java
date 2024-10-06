package com.shadhini.java.tryouts.oop.interfaces.interface_segregation;

public interface Resizable {
    void resize(int size);
    void resize(int width, int height);
    void resize(UIWidget uiWidget);
}
