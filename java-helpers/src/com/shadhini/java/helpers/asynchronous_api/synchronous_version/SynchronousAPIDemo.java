package com.shadhini.java.helpers.asynchronous_api.synchronous_version;

import com.shadhini.java.helpers.asynchronous_api.MailService;

// Synchronous or blocking code
// This code will block the main thread until the mail is sent
// The "Hello, world!" message will not be printed until the mail sending task is completed
public class SynchronousAPIDemo {
    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.send();
        System.out.println("Hello, world!");
        /* Output:
        Mail was sent.
        Hello, world!
         */
    }
}
