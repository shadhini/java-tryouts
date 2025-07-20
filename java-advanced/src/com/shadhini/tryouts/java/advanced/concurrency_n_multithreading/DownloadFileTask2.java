package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadFileTask2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000); // sleep for 5 seconds to simulate file download
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}
