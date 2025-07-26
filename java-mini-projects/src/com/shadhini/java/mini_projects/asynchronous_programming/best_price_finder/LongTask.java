package com.shadhini.java.mini_projects.asynchronous_programming.best_price_finder;

public class LongTask {

    public static void simulate(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
