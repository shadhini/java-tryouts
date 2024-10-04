package com.shadhini.java.tryouts.oop.polymorphism;

public class UIControl {

    private boolean isEnabled = true;

    public UIControl() {
    }

    public UIControl(boolean isEnabled) {
        this.isEnabled = isEnabled;
        System.out.println("UI Control created.");
    }

    public void render() {
        // Default implementation is empty
        // since how to render each type of UI control (e.g: TextBox, CheckBox) is different from each other.
    }

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

}
