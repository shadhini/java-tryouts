package com.shadhini.java.tryouts.tools;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    //TODO: Make code more readable and understandable by breaking it down to small parts

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int MIN_PRINCIPAL = 1000;
        final int MAX_PRINCIPAL = 1_000_000;
        final byte MIN_PERIOD = 1;
        final byte MAX_PERIOD = 30;
        final byte MIN_INTEREST_RATE = 1;
        final byte MAX_INTEREST_RATE = 30;

        int principal = 0;
        byte period = 0;
        int numOfPayments = 0;
        float annualInterestRate = 0;
        float monthlyInterestRate = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= MIN_PRINCIPAL && principal <= MAX_PRINCIPAL)
                break;
            System.out.println("Enter a number between " + MIN_PRINCIPAL + " and " + MAX_PRINCIPAL + ".");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= MIN_INTEREST_RATE && annualInterestRate <= MAX_INTEREST_RATE) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between " + MIN_INTEREST_RATE + " and " + MAX_INTEREST_RATE + ".");
        }

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextByte(); // Maximum would be 30
            if (period >= MIN_PERIOD && period <= MAX_PERIOD) {
                numOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between " + MIN_PERIOD + " and " + MAX_PERIOD + ".");
        }

        // Mortgage calculation
        double power = Math.pow(1  + monthlyInterestRate, numOfPayments);
        double mortgage = (principal * monthlyInterestRate * power) / (power - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
