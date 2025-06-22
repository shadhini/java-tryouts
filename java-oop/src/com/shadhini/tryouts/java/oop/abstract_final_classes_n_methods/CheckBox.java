package com.shadhini.tryouts.java.oop.abstract_final_classes_n_methods;

public final class CheckBox extends UIControl { // Final Class

    @Override
    public void render() {
        System.out.println("CheckBox rendered.");
    }

    public final void toggle() { // Final Method
        System.out.println("CheckBox toggled.");
    }
}
