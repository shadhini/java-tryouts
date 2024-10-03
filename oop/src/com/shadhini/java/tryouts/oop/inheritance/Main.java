package com.shadhini.java.tryouts.oop.inheritance;

public class Main {

    public static void main(String[] args) {
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
        control2.enable();
        control2.setText("Text Box");
        System.out.println(control2.isEnabled()); // Output: true
        System.out.println("==============================================");

        // Methods inherited from `Object` class
        var box1 = new TextBox();
        var box2 = box1;
        System.out.println(box1.hashCode()); // Sample Output: 1975358023
        System.out.println(box2.hashCode()); // Sample Output: 1975358023
        System.out.println(box1.equals(box2)); // Output: true
        System.out.println(box1.toString()); // Output: com.shadhini.java.tryouts.oop.inheritance.TextBox@75bd9247
        System.out.println(box1.getClass()); // Output: class com.shadhini.java.tryouts.oop.inheritance.TextBox
        System.out.println("==============================================");

        //Method Overriding
        System.out.println("================Method Overriding==============================");
        var textBox = new TextBox();
        textBox.setText("----Text of TextBox class.----");
        // Method inherited from Object class
        System.out.println(textBox.toString()); // Output: com.shadhini.java.tryouts.oop.inheritance.TextBox@7d417077
        System.out.println(textBox); // Output: com.shadhini.java.tryouts.oop.inheritance.TextBox@7d417077
        var textBox2 = new TextBox2();
        textBox2.setText("----Text of TextBox2 class.----");
        // Method inherited from Object class is overridden by method declaration at TextBox2 class
        System.out.println(textBox2.toString()); // Output: ----Text of TextBox2 class.----
        System.out.println(textBox2); // Output: ----Text of TextBox2 class.----
        System.out.println("==============================================");

    }
}
