package com.shadhini.java.tryouts.oop.interfaces.new_features;

public interface TaxCalculator {

    double calculateTax();

    // [not recommended to use]
    static double getTaxableIncome(double income, double expenses) {
        return income - expenses;
    }
}
