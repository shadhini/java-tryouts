package com.shadhini.creational.abstract_factory_pattern;

public class BussinessLoan extends Loan{
    @Override
    void getInterestRate(double r) {
        rate = r;
    }
}
