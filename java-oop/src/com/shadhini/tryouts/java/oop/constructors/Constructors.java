package com.shadhini.tryouts.java.oop.constructors;

/**
 * Demonstration of Constructors.
 */
public class Constructors {

    public static void demo() {
        var employee = new Employee(50_000, 20);
        var wage = employee.calculateWage(10);
        System.out.println(wage);

    }
}
