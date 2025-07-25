package com.shadhini.tryouts.java.advanced.executive_framework.asynchronous_programming;

import com.shadhini.tryouts.java.advanced.executive_framework.threadpool.LongTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFuturesDemo {

    public static void main(String[] args) {

        // Creating a CompletableFuture --------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Creating a CompletableFuture ------------------------------------------------------------");
        createCompletableFutureObject();

        // Running code on completion of a CompletableFuture -----------------------------------------------------------
        // =============================================================================================================
        System.out.println("Running code on completion of a CompletableFuture ---------------------------------------");
        runAfterCompletion();
        runAfterCompletionInAsyncMode();
        acceptAfterCompletion();
        acceptAfterCompletionInAsyncMode();

        // Handling exceptions in CompletableFuture --------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Handling exceptions in CompletableFuture ------------------------------------------------");
        catchExceptionFromCompletableFuture();
        returnDefaultIfAnExceptionThrown();

        // Transforming the result of a CompletableFuture --------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Transforming the result of a CompletableFuture ------------------------------------------");
        transformResultOfCompletableFuture();

        // Composing CompletableFutures for Task after Task ------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Composing CompletableFutures for Task after Task ----------------------------------------");
        composeCompletableFuturesForTaskAfterTask();

        // Combining multiple CompletableFutures -----------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Combining multiple CompletableFutures ---------------------------------------------------");
        // running multiple tasks at the same time and then combine the results
        combiningMultipleCompletableFuturesV1();
        combiningMultipleCompletableFuturesV2();

        // Waiting for many tasks to complete --------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Waiting for many tasks to complete ------------------------------------------------------");
        waitingForManyTasksToComplete();

        // Waiting for the first task to complete ----------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Waiting for the first task to complete --------------------------------------------------");
        waitingForTheFirstTaskToComplete();

        // Handling timeouts in CompletableFuture ----------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Handling timeouts in CompletableFuture --------------------------------------------------");
        timeoutCompletableFuture();
        recoverAfterTimeoutWithDefaultValue();

    }

    private static void recoverAfterTimeoutWithDefaultValue() {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(); // runs for 3 seconds
            return 1;
        });

        try {
            var result = future
                    .completeOnTimeout(100, 1, TimeUnit.SECONDS) // wait for 1 second for the task to complete
                    .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // Output: 100
    }

    private static void timeoutCompletableFuture() {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(); // runs for 3 seconds
            return 1;
        });

        try {
            var result = future.orTimeout(1, TimeUnit.SECONDS) // wait for 1 second for the task to complete
                    .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        /* Output:
            java.util.concurrent.ExecutionException: java.util.concurrent.TimeoutException
	        ....
            Caused by: java.util.concurrent.TimeoutException
	        ....
         */
    }

    private static void waitingForTheFirstTaskToComplete() {
        var firstTask = CompletableFuture.supplyAsync(() -> { // the slow service call
            LongTask.simulate();
            return 20;
        });
        var secondTask = CompletableFuture.supplyAsync(() -> 30); // the fast service call


        var fastest = CompletableFuture.anyOf(firstTask, secondTask);
        fastest.thenAccept(temp -> System.out.println(temp));
        // Output: 30
    }

    private static void waitingForManyTasksToComplete() {
        var firstTask = CompletableFuture.supplyAsync(() -> 1);
        var secondTask = CompletableFuture.supplyAsync(() -> 2);
        var thirdTask = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(firstTask, secondTask, thirdTask);
        all.thenRun(() -> {
            try {
                var firstResult = firstTask.get(); // --------A
                System.out.println(firstResult);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All tasks completed successfully!");
        });
        /* Output:
            1
            All tasks completed successfully!
         */
    }

    private static void combiningMultipleCompletableFuturesV2() {
        // if first task returns the price as a String
        var firstTask = CompletableFuture
                .supplyAsync(() -> "20USD") // retrieve price of the item
                .thenApply(str -> { // convert the price to an Integer
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                });
        var secondTask = CompletableFuture.supplyAsync(() -> 300); // retrieve exchange rate USD to LKR
        firstTask
                .thenCombine(secondTask, (price, exchangeRate) -> price * exchangeRate) // combine the results of the two tasks
                .thenAccept(totalPrice -> System.out.println("Total price in LKR: " + totalPrice));
        // Output: Total price in LKR: 6000
    }

    private static void combiningMultipleCompletableFuturesV1() {
        var firstTask = CompletableFuture.supplyAsync(() -> 20); // retrieve price of the item
        var secondTask = CompletableFuture.supplyAsync(() -> 300); // retrieve exchange rate USD to LKR
        firstTask
            .thenCombine(secondTask, (price, exchangeRate) -> price * exchangeRate) // combine the results of the two tasks
            .thenAccept(totalPrice -> System.out.println("Total price in LKR: " + totalPrice));
        // Output: Total price in LKR: 6000
    }

    private static void composeCompletableFuturesForTaskAfterTask() {
        // id -> email
        // email -> playlist
        // Option 1:
        CompletableFuture.supplyAsync(() -> "email") // operation to get the email for given id
            .thenCompose(email -> CompletableFuture.supplyAsync(() -> "playlist for " + email)) // operation to get the playlist for given email
            .thenAccept(playlist -> System.out.println("Playlist: " + playlist));

        // Option 2: similar to real world scenario
        getUserEmailAsync(1) // id -> email
                .thenCompose(CompletableFuturesDemo:: getUserPlaylistAsync) // email -> playlist
                .thenAccept(playlist -> System.out.println("Playlist: " + playlist));
    }

    private static void transformResultOfCompletableFuture() {
        var future = CompletableFuture.supplyAsync(() -> 20); // say, this returns temperature in Celsius
        future
            .thenApply(CompletableFuturesDemo:: toFahrenheit) // convert celsius to fahrenheit
            .thenAccept(System.out::println);
        // Output: 68.0
    }

    private static void returnDefaultIfAnExceptionThrown() {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather...");
            throw new IllegalStateException("Weather service is down");
        });

        try {
            var result = future.exceptionally(ex -> 1).get();
            // say, the value `1` is the last temperature we read successfully
            System.out.println("The current temperature is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.getCause();
            e.printStackTrace();
        }
    }

    private static void catchExceptionFromCompletableFuture() {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather...");
            throw new IllegalStateException("Weather service is down");
        });

        /* Output:
            Getting the current weather...

         */

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.getCause();
            e.printStackTrace();
        }

        /* Output:
            Getting the current weather...
            java.util.concurrent.ExecutionException: java.lang.IllegalStateException: Weather service is down
                at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:395)
                at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1999)
                at com.shadhini.tryouts.java.advanced.executive_framework.asynchronous_programming.CompletableFuturesDemo.main(CompletableFuturesDemo.java:45)
            Caused by: java.lang.IllegalStateException: Weather service is down
        */
    }

    private static void acceptAfterCompletionInAsyncMode() {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed with result: " + result);
        });
        /* Output:
            ForkJoinPool.commonPool-worker-19
        */
    }

    private static void acceptAfterCompletion() {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenAccept(result -> {;
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed with result: " + result);
        });
        /* Output:
            main
            Task completed with result: 1
        */
    }

    private static void runAfterCompletionInAsyncMode() {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed!");
        });
        /* Output:
            ForkJoinPool.commonPool-worker-19
            Task completed!
        */
    }

    private static void runAfterCompletion() {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed!");
        });
        /* Output:
            main
            Task completed!
        */
    }

    private static void createCompletableFutureObject() {
        Runnable task = () -> System.out.println("a");
        // execute a task that doesn't return a value in asynchronous fashion
        var completableFuture = CompletableFuture.runAsync(task);
        // Here, the completableFuture object is of type java.util.concurrent.CompletableFuture<Void>,
        //      as we are not returning anything

        // execute a task that returns a value in asynchronous fashion
        Supplier<Integer> taskWithValue = () -> 1;
        var completableFutureWithValue = CompletableFuture.supplyAsync(taskWithValue);
        // the type of the completableFutureWithValue object is CompletableFuture of Integer
        //      java.util.concurrent.CompletableFuture<Integer>

        try {
            // the .get() method inherited from the Future interface is blocking the current/main thread
            var result = completableFutureWithValue.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    // helper methods --------------------------------------------------------------------------------

    // convert Celsius to Fahrenheit
    public static int toFahrenheit(int celsius) {
        return (int) ((celsius * 1.8) + 32);
    }

    // get user email for given ID
    public static CompletableFuture<String> getUserEmailAsync(int id) {
        // return a CompletableFuture as querying a database is a long-running task
        return CompletableFuture.supplyAsync(() -> "user" + id + "@example.com");
    }

    // get user playlist for given email
    public static CompletableFuture<String> getUserPlaylistAsync(String email) {
        // return a CompletableFuture as querying a database is a long-running task
        return CompletableFuture.supplyAsync(() -> "playlist for " + email);
    }



}
