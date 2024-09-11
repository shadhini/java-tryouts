package com.shadhini.java.tryouts.tools;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber(
                "Annual Interest Rate: ", 1, 30);
        byte period = (byte) readNumber("Period (Years): ", 1, 30);

        displayMortgage(principal, annualInterestRate, period);
        displayPaymentSchedule(principal, annualInterestRate, period);
    }

    /**
     * Display Mortgage
     * @param principal principal amount of the loan
     * @param annualInterestRate annual interest rate of the loan
     * @param period loan payment period in years
     */
    private static void displayMortgage(int principal, float annualInterestRate, byte period) {
        double mortgage = calculateMortgage(principal, annualInterestRate, period);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("______________________");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    /**
     * Display Payment Schedule
     * @param principal principal amount of the loan
     * @param annualInterestRate annual interest rate of the loan
     * @param period loan payment period in years
     */
    private static void displayPaymentSchedule(int principal, float annualInterestRate, byte period) {
        double[] paymentSchedule = calculatePaymentSchedule(principal, annualInterestRate, period);
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("______________________");
        for (double payment: paymentSchedule)
            System.out.println(NumberFormat.getCurrencyInstance().format(payment));
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
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
        return value;
    }

    /**
     * Calculate mortgage
     * @param principal principal amount of the loan
     * @param annualInterestRate annual interest rate of the loan
     * @param period loan payment period in years
     * @return monthly payment as a double
     */
    public static double calculateMortgage(int principal, float annualInterestRate, byte period) {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numOfPayments = (short) (period * MONTHS_IN_YEAR);

        double intermediateCalc = Math.pow(1  + monthlyInterestRate, numOfPayments);
        return  (principal * monthlyInterestRate * intermediateCalc) / (intermediateCalc - 1);
    }

    /**
     * Calculate the whole Payment Schedule
     * @param principal principal amount of loan
     * @param annualInterestRate annual interest rate of loan
     * @param period loan payment period in years
     * @return loan balance at the end of each month as a list of doubles
     */
    public static double[] calculatePaymentSchedule(int principal, float annualInterestRate, byte period) {

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numOfPayments = (short) (period * MONTHS_IN_YEAR);

        double[] paymentSchedule = new double[numOfPayments];

        double intermediateCalc = Math.pow(1  + monthlyInterestRate, numOfPayments);
        for (int i = 1; i <= numOfPayments; i++)
            paymentSchedule[i-1] =
                    principal * (intermediateCalc - Math.pow((1 + monthlyInterestRate), i)) / (intermediateCalc - 1);
        return paymentSchedule;
    }
}
