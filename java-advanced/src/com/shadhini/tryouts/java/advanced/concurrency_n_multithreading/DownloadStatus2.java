package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus2 {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    // when a thread enters this method, it will lock the lock object
    // now other threads cannot enter this method until the lock is released
    public void incrementTotalBytes() {
        lock.lock();
        try {
            // critical section
            // this is where we modify the shared resource
            totalBytes++;
        } finally {
            // this block will always execute, even if an exception occurs
            // it ensures that the lock is released
            lock.unlock();
        }
        // best practice is to use try-finally block
    }
}
