package com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.setter_injection;

public class TaxCalculator2024 implements TaxCalculator {

    private double taxableIncome;

    public TaxCalculator2024(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        return taxableIncome * 0.3;
    }
}
