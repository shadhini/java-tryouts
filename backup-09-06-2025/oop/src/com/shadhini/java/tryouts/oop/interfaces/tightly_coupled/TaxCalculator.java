package com.shadhini.java.tryouts.oop.interfaces.tightly_coupled;

public class TaxCalculator {

    private double taxableIncome;

    public TaxCalculator(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double calculateTax() {
        return taxableIncome * 0.3;
    }
}
