package com.shadhini.java.tryouts.oop.inheritance;

public class UIControl {

    private boolean isEnabled = true;

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
