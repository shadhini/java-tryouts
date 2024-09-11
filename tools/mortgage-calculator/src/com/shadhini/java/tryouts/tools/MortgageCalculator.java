package com.shadhini.java.tryouts.tools;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        final int MIN_PRINCIPAL = 1000;
        final int MAX_PRINCIPAL = 1_000_000;
        final byte MIN_PERIOD = 1;
        final byte MAX_PERIOD = 30;
        final byte MIN_INTEREST_RATE = 1;
        final byte MAX_INTEREST_RATE = 30;

        int principal = (int) readNumber("Principal($1K - $1M): ", MIN_PRINCIPAL, MAX_PRINCIPAL);
        float annualInterestRate = (float) readNumber(
                "Annual Interest Rate: ", MIN_INTEREST_RATE, MAX_INTEREST_RATE);
        byte period = (byte) readNumber("Period (Years): ", MIN_PERIOD, MAX_PERIOD);

        double mortgage = calculateMortgage(principal, annualInterestRate, period);

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    /**
     * Calculate mortgage
     * @param principal principal amount of the loan
     * @param annualInterestRate annual interest rate of the loan
     * @param period loan payment period in years
     * @return monthly payment as a double
     */
    public static double calculateMortgage(int principal, float annualInterestRate, byte period) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numOfPayments = (short) (period * MONTHS_IN_YEAR);

        double intermediateCalc = Math.pow(1  + monthlyInterestRate, numOfPayments);
        return  (principal * monthlyInterestRate * intermediateCalc) / (intermediateCalc - 1);
    }

    /**
     * Reads a number input from the terminal
     * @param prompt prompt
     * @param min minimum value of the input
     * @param max maximum value of the input
     * @return user input as a double
     */
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
        return value;
    }
}
