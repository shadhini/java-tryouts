package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadFileTask3 implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        for (var i = 0; i < Integer.MAX_VALUE; i++) {
            // check for an interrupt signal/request
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Download interrupted in thread: " + Thread.currentThread().getName());
                return; // exit the run method if the thread is interrupted
            }
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
