package com.shadhini.tryouts.java.oop.inheritance;

import com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.CastingDemo;

/**
 * Demonstration of Inheritance in Java.
 */
public class InheritanceDemo {

    public static void demo() {
        // Inheritance & Constructors
        System.out.println("================Constructors & Inheritance==============================");
        var control = new UIControl();
        // Output: UI Control created.
        control.disable();
        System.out.println(control.isEnabled()); // Output: false
        System.out.println("==============================================");

        var control2 = new TextBox();
        /* Output:
        UI Control created.
        Text Box created.
         */
        control2.enable(); // call method declared in UIControl class (super class)
        control2.setText("Text Box");
        System.out.println(control2.isEnabled()); // Output: true
        System.out.println("==============================================");

        // Methods inherited from `Object` class
        System.out.println("================Object Class==============================");
        var box1 = new TextBox();
        var box2 = box1;
        // HashCode: hash address based on the address of this object in memory
        System.out.println(box1.hashCode()); // Sample Output: 1975358023
        System.out.println(box2.hashCode()); // Sample Output: 1975358023
        // Comparing objects based on the hashcode
        var box3 = new TextBox();
        System.out.println(box1.equals(box2)); // Output: true
        System.out.println(box1.equals(box3)); // Output: false
        System.out.println(box1.toString()); // Output: com.shadhini.tryouts.java.oop.inheritance.TextBox@75bd9247
        System.out.println(box1.getClass()); // Output: class com.shadhini.tryouts.java.oop.inheritance.TextBox
        System.out.println("==============================================");

        //Method Overriding
        System.out.println("================Method Overriding==============================");
        var textBox = new TextBox();
        textBox.setText("----Text of TextBox class.----");
        // Method inherited from Object class
        System.out.println(textBox.toString()); // Output: com.shadhini.tryouts.java.oop.inheritance.TextBox@7d417077
        System.out.println(textBox); // Output: com.shadhini.tryouts.java.oop.inheritance.TextBox@7d417077

        var textBox2 = new TextBox2();
        textBox2.setText("----Text of TextBox2 class.----");
        // Method inherited from Object class is overridden by method declaration at TextBox2 class
        System.out.println(textBox2.toString()); // Output: ----Text of TextBox2 class.----
        System.out.println(textBox2); // Output: ----Text of TextBox2 class.----
        System.out.println("==============================================");

        //Upcasting & Downcasting
        System.out.println("===========Upcasting & Downcasting==============================");
        CastingDemo.demo();
        System.out.println("==============================================");
    }

}
