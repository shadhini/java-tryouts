package com.shadhini.java.tryouts.tools.mortgage_calculator.oop;

/**
 * Mortgage Calculator: Responsible for mortgage calculations
 * Handles mortgage related presentation concerns
 */
public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float annualInterestRate;
    private byte period;

    public MortgageCalculator(int principal,  float annualInterestRate, byte period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    /**
     * Calculate mortgage
     *
     * @return monthly payment as a double
     */
    public double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numOfPayments = getNumOfPayments();

        double intermediateCalc = Math.pow(1 + monthlyInterestRate, numOfPayments);
        return (principal * monthlyInterestRate * intermediateCalc) / (intermediateCalc - 1);
    }

    /**
     * Calculate the whole Payment Schedule
     *
     * @return loan balance at the end of each month as a list of doubles
     */
    public double[] calculatePaymentSchedule() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numOfPayments = getNumOfPayments();
        var paymentSchedule = new double[numOfPayments];
        double intermediateCalc = Math.pow(1 + monthlyInterestRate, numOfPayments);
        for (int month = 1; month <= numOfPayments; month++)
            paymentSchedule[month - 1] =
                    principal * (intermediateCalc - Math.pow((1 + monthlyInterestRate), month)) / (intermediateCalc - 1);
        return paymentSchedule;
    }

    private short getNumOfPayments() {
        return (short) (period * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterestRate() {
        // If we move this logic to the constructor and create a field for monthlyInterest,
        //  then we have to repeat that logic in the method setAnnualInterest too.
        // Bcz, every time annual interest is changed monthly interest should be changed accordingly.
        // That will introduce a duplication of logic again.
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }

}
