package com.shadhini.java.helpers.asynchronous_api;

import java.util.concurrent.CompletableFuture;

public class MailService {

    // synchronous mail sending service
    public void send() {
        // a long running task
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    // asynchronous mail sending service
    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(this::send);
    }
}
