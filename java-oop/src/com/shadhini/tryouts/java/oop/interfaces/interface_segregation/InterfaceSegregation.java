package com.shadhini.tryouts.java.oop.interfaces.interface_segregation;

public class InterfaceSegregation {

    public static void demo() {
        Slider slider = new Slider();
        Dragger dragger = new Dragger();

        dragger.drag(slider);
    }
}
