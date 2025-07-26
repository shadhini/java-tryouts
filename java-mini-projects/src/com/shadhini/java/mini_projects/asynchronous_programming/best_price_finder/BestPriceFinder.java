package com.shadhini.java.mini_projects.asynchronous_programming.best_price_finder;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BestPriceFinder {

    public static void main(String[] args) {
        var start = System.currentTimeMillis();

        var flightService = new FlightService();
        var quotes = flightService.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture.allOf(quotes.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                        var executionTime = System.currentTimeMillis() - start;
                        System.out.println("Retrieved all quotes in " + executionTime + " msec");
                });


        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
