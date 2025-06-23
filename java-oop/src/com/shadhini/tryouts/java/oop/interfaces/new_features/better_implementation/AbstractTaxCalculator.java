package com.shadhini.tryouts.java.oop.interfaces.new_features.better_implementation;

public abstract class AbstractTaxCalculator implements TaxCalculator{

    protected static double getTaxableIncome(double income, double expenses) {
        return income - expenses;
    }
}
