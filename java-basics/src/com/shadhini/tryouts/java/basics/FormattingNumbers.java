package com.shadhini.tryouts.java.basics;

import java.text.NumberFormat;

/**
 * Formatting numbers in Java.
 * [java.text.NumberFormat]
 */
public class FormattingNumbers {

    public static void demo() {

        // Currency: e.g.: 1234567.891 as $1,234,567.89
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String currencyValue = currency.format(1234567.891);
        System.out.println(currencyValue); // Output: LKR1,234,567.89

        // Percentage: e.g: 0.1 as 10%
        NumberFormat percentage = NumberFormat.getPercentInstance();
        String percentageValue = percentage.format(0.1);
        System.out.println(percentageValue); // Output: 10%

        // Number Formatting: e.g.: 1234567.891 as 1,234,567.891
        System.out.println(NumberFormat.getNumberInstance().format(1234567.891)); // Output: 1,234,567.891



    }
}
