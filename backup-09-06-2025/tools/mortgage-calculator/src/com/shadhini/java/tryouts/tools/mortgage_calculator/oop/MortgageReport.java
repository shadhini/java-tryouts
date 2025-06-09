package com.shadhini.java.tryouts.tools.mortgage_calculator.oop;

import java.text.NumberFormat;

/**
 * Mortgage Report: responsible for displaying mortgage calculations
 */
public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    /**
     * Display Payment Schedule
     */
    public void displayPaymentSchedule() {
        double[] paymentSchedule = mortgageCalculator.calculatePaymentSchedule();
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("______________________");
        for (double payment : paymentSchedule)
            System.out.println(currency.format(payment));
    }

    /**
     * Display Mortgage
     */
    public void displayMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("______________________");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }
}
