package com.shadhini.java.tryouts.oop.inheritance;

public class Main {

    public static void main(String[] args) {
        var control = new UIControl();
        control.disable();
        System.out.println(control.isEnabled());

        var control2 = new TextBox();
        control2.enable();
        control2.setText("Text Box");
        System.out.println(control2.isEnabled());

    }
}
