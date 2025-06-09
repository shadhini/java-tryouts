package com.shadhini.java.tryouts.oop.constructors;

/**
 * Demonstration of Constructors.
 */
public class Main {

    public static void main(String[] args) {
        var employee = new Employee(50_000, 20);
        var wage = employee.calculateWage(10);
        System.out.println(wage);

    }
}
