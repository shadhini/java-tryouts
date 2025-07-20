package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadFileTask1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());
    }
}
