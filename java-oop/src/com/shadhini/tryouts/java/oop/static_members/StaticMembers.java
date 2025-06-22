package com.shadhini.tryouts.java.oop.static_members;

/**
 * Demonstration of Static Members.
 */
public class StaticMembers {

    public static void demo() {
        var employee1 = new Employee(50_000, 3);
        Employee.printNumberOfEmployees();
        var wage = employee1.calculateWage(0);
        System.out.println(wage);

        new Employee(50_000, 1);
        new Employee(50_000, 2);
        System.out.println(Employee.numberOfEmployees);

    }
}
