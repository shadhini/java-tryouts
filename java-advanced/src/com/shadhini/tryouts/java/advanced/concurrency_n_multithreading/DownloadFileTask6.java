package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadFileTask6 implements Runnable {

    private final DownloadStatus3 status;

    public DownloadFileTask6(DownloadStatus3 status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        for (var i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return; // exit the run method if the thread is interrupted
            status.incrementTotalBytes();
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}
