package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadStatus4 {

    private volatile boolean isDone;
    private int totalBytes;
    private final Object totalBytesLock = new Object(); // lock for totalBytes

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) { // synchronized block
            totalBytes++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
