package com.shadhini.java.tryouts.oop.encapsulation;

/**
 * Demonstration of Encapsulation.
 */
public class Main {

    // Main class is dependent on the Employee class
    // Main class has 4 coupling points to the Employee class
    public static void main(String[] args) {
        var employee = new Employee(); // First coupling point
        // employee.setBaseSalary(-1); // Output: --> java.lang.IllegalArgumentException: Base salary cannot be 0 or less.
        employee.setBaseSalary(50_000);
        employee.setHourlyRate(20);
        int wage = employee.calculateWage(10);
        System.out.println(wage);
    }

}
