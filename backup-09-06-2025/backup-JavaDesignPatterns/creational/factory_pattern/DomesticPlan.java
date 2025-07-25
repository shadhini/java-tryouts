package com.shadhini.creational.factory_pattern;

// concrete class
public class DomesticPlan extends Plan {
    @Override
    void getRate() {
        rate = 3.50;
    }
}
