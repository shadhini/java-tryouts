package com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting;

public class CastingDemo {

    public static void demo() {
        var textBox = new CTextBox();
        textBox.setText("Initial Text");
        System.out.println("---------------------------------");

        // Upcasting
        // =============================================================================================================
        show(textBox); // Upcasting happens here
        /* Output:
        Initial Text
         */
        System.out.println("---------------------------------");

        // Downcasting
        // =============================================================================================================
        show2(textBox);
        /* Output:
        Initial Text
        Happy Downcasting...
         */
        System.out.println("---------------------------------");

        // java.lang.ClassCastException while Downcasting
        // =============================================================================================================
        var uiControl = new CUIControl();
//        show2(uiControl);
        /* Output:
        com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.CUIControl@75bd9
        --> java.lang.ClassCastException
         */
        System.out.println("---------------------------------");

        // Prevent runtime ClassCastException
        // =============================================================================================================
        show3(uiControl);
        /* Output:
        com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.CUIControl@75bd9247
         */
        System.out.println("---------------------------------");

    }

    public static void show(CUIControl uiControl) {
        System.out.println(uiControl); // --- A
        // Here, @runtime we are sending a CTextBox object to the show() method.
        // Thus, @runtime when line A is executed, the toString() method of CTextBox class is executed.
    }

    public static void show2(CUIControl uiControl) {
        System.out.println(uiControl);
        // @compile time we cannot access members of the CTextBox class, without downcasting.
        CTextBox textBox = (CTextBox) uiControl; // Downcasting happens here
        textBox.setText("Happy Downcasting...");
        System.out.println(textBox);
    }

    public static void show3(CUIControl uiControl) {
        System.out.println(uiControl);
        if (uiControl instanceof CTextBox) { // ClassCastException Prevention
            CTextBox textBox = (CTextBox) uiControl;
            textBox.setText("Happy Downcasting...");
            System.out.println(textBox);
        }
    }

}
