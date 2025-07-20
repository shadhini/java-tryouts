package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

public class DownloadStatus3 {
    private int totalBytes;
    private int totalFiles; // keep track of the number of files downloaded so far
    private int currentBytes;
    private final Object totalBytesLock = new Object(); // lock for totalBytes
    private final Object totalFilesLock = new Object(); // lock for totalFiles

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) { // synchronized block
            totalBytes++;
        }
    }

    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    // synchronized method
    public synchronized void incrementCurrentBytes() {
        currentBytes++;
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public int getTotalFiles() {
        return totalFiles;
    }
}
