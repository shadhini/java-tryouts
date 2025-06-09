package com.shadhini.java.tryouts.oop.static_members;

/**
 * Demonstration of Static Members.
 */
public class Main {

    public static void main(String[] args) {
        var employee1 = new Employee(50_000, 0);
        Employee.printNumberOfEmployees();
        var wage = employee1.calculateWage(0);
        System.out.println(wage);

    }
}
