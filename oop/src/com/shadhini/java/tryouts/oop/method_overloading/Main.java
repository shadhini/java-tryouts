package com.shadhini.java.tryouts.oop.method_overloading;

public class Main {

    // In this scenario not using method overloading and just passing 0 as in A is better
    public static void main(String[] args) {
        var employee = new Employee(50_000, 20);
        var wage = employee.calculateWage(0); // -- A
        var wage2 = employee.calculateWage();
        System.out.println(wage + " " + wage2);

    }
}
