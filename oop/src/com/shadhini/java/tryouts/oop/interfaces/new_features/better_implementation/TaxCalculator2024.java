package com.shadhini.java.tryouts.oop.interfaces.new_features.better_implementation;

public class TaxCalculator2024 extends AbstractTaxCalculator {
    // We have inherited some behavior from parents, but they are not exposed to outside
    // And we have kept our contract/interface clean

    private double taxableIncome;

    public TaxCalculator2024(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        return getTaxableIncome(100_000, 50_000) * 0.3;
    }
}
