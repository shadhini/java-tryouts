package com.shadhini.tryouts.java.basics.control_flow;

/**
 * Java logical operators.
 */
public class LogicalOperators {

    public static void demo() {

        // AND
        int temperature = 12;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);

        // OR
        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        // is eligible for a loan
        boolean isEligible = hasHighIncome || hasGoodCredit;
        System.out.println(isEligible);

        // NOT
        boolean hasCriminalRecord = true;
        boolean isEligibleNew = (hasHighIncome || hasGoodCredit) && hasCriminalRecord;


    }
}
