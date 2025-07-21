package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus5 {
    private AtomicInteger totalBytes = new AtomicInteger();

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementTotalBytes() {
        totalBytes.incrementAndGet();
    }
}
