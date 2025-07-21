package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    private LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
        return totalBytes.intValue();
        // internally this method called sum() which returns the sum of all counter values added to this LongAdder,
        //      and then it converts the result into an integer
    }

    public void incrementTotalBytes() {
        totalBytes.increment();
    }
}
