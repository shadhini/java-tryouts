package com.shadhini.java.mini_projects.asynchronous_programming.best_price_finder;

import java.util.HashMap;

public class Quote {

    private String site;
    private double price;

    public Quote(String site, double price) {
        this.site = site;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{site='"+ this.site + "', price="+ this.price + "}";
    }

    public String getSite() {
        return site;
    }

    public double getPrice() {
        return price;
    }
}
