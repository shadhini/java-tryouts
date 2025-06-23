package com.shadhini.tryouts.java.oop.interfaces.new_features;

public interface TaxCalculator {

    // An abstract method
    double calculateTax();

    // Static Method [not recommended to use]
    static double getTaxableIncome(double income, double expenses) {
        return income - expenses;
    }

    // Default method [not recommended to use]
    default void printTwice(String message) {
        System.out.println(message);
        System.out.println(message);
    }

    // Private method [not recommended to use]
}
