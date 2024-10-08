package com.shadhini.java.tryouts.oop.procedural_programming;

/**
 * An example of procedural programming.
 * This program calculate the wage of the employees.
 */
public class Main {

    // Note: Here we are not worrying about allocating memory for variables in an optimal way for simplicity
    public static void main(String[] args) {
        int baseSalary = 50_000;
        int extraHours = 10;
        int hourlyRate = 20;

        int wage = calculateWage(baseSalary, extraHours, hourlyRate);
        System.out.println(wage);

    }

    public static int calculateWage(int baseSalary, int extraHours, int hourlyRate) {
        return baseSalary + (extraHours * hourlyRate);
    }
}
