package com.shadhini.java.helpers.asynchronous_api;

// Asynchronous API demo
public class AsynchronousAPIDemo {

    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.sendAsync();
        System.out.println("Hello, world!");
        /* Output:
        Hello, world!
         */

        try {
            Thread.sleep(5000); // wait for the async task to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
