package com.shadhini.java.tryouts.tools.oop;

/**
 * Mortgage Calculator
 * [Object-Oriented Programming]
 */
public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber(
                "Annual Interest Rate: ", 1, 30);
        byte period = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var mortgageCalculator = new MortgageCalculator(principal, annualInterestRate, period);
        var mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.displayMortgage();
        mortgageReport.displayPaymentSchedule();
    }

}
