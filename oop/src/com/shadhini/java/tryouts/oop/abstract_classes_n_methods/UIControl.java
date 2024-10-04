package com.shadhini.java.tryouts.oop.abstract_classes_n_methods;

public abstract class UIControl { // Abstract Class

    private boolean isEnabled = true;

    public UIControl() {
    }

    public UIControl(boolean isEnabled) {
        this.isEnabled = isEnabled;
        System.out.println("UI Control created.");
    }

    public abstract void render(); // Abstract Method

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
