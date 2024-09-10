package com.shadhini.java.tryouts.tools;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    //TODO: Input Validation

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte(); // Maximum would be 30
        int numOfPayments = period / MONTHS_IN_YEAR;

        // Mortgage calculation

        double power = Math.pow(1  + monthlyInterestRate, numOfPayments);
        double mortgage = (principal * monthlyInterestRate * power) / (power - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
