package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadFileTask7 implements Runnable {

    private final DownloadStatus status;

    public DownloadFileTask7(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        for (var i = 0; i < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return; // exit the run method if the thread is interrupted
            status.incrementTotalBytes();
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        status.done(); // mark the download as done

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}
