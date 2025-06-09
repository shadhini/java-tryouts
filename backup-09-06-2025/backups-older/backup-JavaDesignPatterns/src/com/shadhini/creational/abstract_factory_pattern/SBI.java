package com.shadhini.creational.abstract_factory_pattern;

public class SBI implements Bank{
    private final String BNAME;

    public SBI() {
        BNAME = "SBI BANK";
    }

    @Override
    public String getBankName() {
        return BNAME;
    }
}
