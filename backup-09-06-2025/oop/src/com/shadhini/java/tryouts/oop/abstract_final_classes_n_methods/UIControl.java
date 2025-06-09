package com.shadhini.java.tryouts.oop.abstract_final_classes_n_methods;

public abstract class UIControl { // Abstract Class

    private boolean isEnabled = true;

    public UIControl() {
    }

    public UIControl(boolean isEnabled) {
        this.isEnabled = isEnabled;
        System.out.println("UI Control created.");
    }

    public abstract void render(); // Abstract Method

    public final void enable() {
        isEnabled = true;
    } // Final Method

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

}
