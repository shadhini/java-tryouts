package com.shadhini.java.tryouts.oop.inheritance;

public class Main {

    public static void main(String[] args) {
        var control = new UIControl();
        control.disable();
        System.out.println(control.isEnabled()); // Output: false

        var control2 = new TextBox();
        control2.enable();
        control2.setText("Text Box");
        System.out.println(control2.isEnabled()); // Output: true

        // Methods inherited from `Object` class
        var box1 = new TextBox();
        var box2 = box1;
        System.out.println(box1.hashCode()); // Sample Output: 1975358023
        System.out.println(box2.hashCode()); // Sample Output: 1975358023
        System.out.println(box1.equals(box2)); // Output: true
        System.out.println(box1.toString()); // Output: com.shadhini.java.tryouts.oop.inheritance.TextBox@75bd9247
        System.out.println(box1.getClass()); // Output: class com.shadhini.java.tryouts.oop.inheritance.TextBox

    }
}
