package com.shadhini.java.tryouts.oop.inheritance;

public class Main {

    public static void main(String[] args) {
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
        control2.enable();
        control2.setText("Text Box");
        System.out.println(control2.isEnabled()); // Output: true
        System.out.println("==============================================");

        // Methods inherited from `Object` class
        System.out.println("================Object Class==============================");
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

        //Upcasting & Downcasting
        System.out.println("===========Upcasting & Downcasting==============================");
        var uiControl = new UIControl();
//        show(uiControl);
        /* Output:
            com.shadhini.java.tryouts.oop.inheritance.UIControl@35bbe5e8
            @Line A --> java.lang.ClassCastException: UIControl cannot be cast to TextBox2
         */
        show2(uiControl);
        /* Output:
            com.shadhini.java.tryouts.oop.inheritance.UIControl@35bbe5e8
         */
        var textBox21 = new TextBox2();
        show(textBox21);
        /* Output:
            null
            Happy Upcasting...
         */
        System.out.println("==============================================");
    }

    public static void show(UIControl uiControl) {
        System.out.println(uiControl);
        TextBox2 textBox = (TextBox2) uiControl; // -- A
        textBox.setText("Happy Upcasting...");
        System.out.println(textBox);
    }

    // This method prevents ClassCastException during runtime when downcasting
    public static void show2(UIControl uiControl) {
        System.out.println(uiControl);
        if (uiControl instanceof TextBox) {
            TextBox2 textBox = (TextBox2) uiControl;
            textBox.setText("Happy Upcasting...");
            System.out.println(textBox);
        }
    }
}
