package com.shadhini.tryouts.java.oop.encapsulation;

/**
 * Employee Class
 */
public class Employee {

    private int baseSalary;
    private int hourlyRate;

    public int calculateWage(int extraHours) {
        // Note: with procedural programming we had 3 parameters.
        // Now we have 1 parameter
        //   as many parameters required to calculate wage are attributes of this class;
        //   no need to pass them from outside.
        // The extraHours is set as a method parameter since it changes every month.
        // But base salary and hourly rate don't change that often;
        //   these are fixed values per employee for about a year.
        return baseSalary + hourlyRate * extraHours;
    }

    public void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary cannot be 0 or less.");
        }
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
        }
        this.hourlyRate = hourlyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
