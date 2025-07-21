package com.shadhini.tryouts.java.advanced.concurrency_n_multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {

        // returns number of active threads in the current process; current thread's thread group and its subgroups
        System.out.println(Thread.activeCount());
        // Output: 2
        // This program is using 2 threads:
        // 1. main thread: the one that runs the main method
        // 2. background thread: the one that runs the garbage collector which remove unused objects from the memory

        // returns total number of available threads
        System.out.println(Runtime.getRuntime().availableProcessors());
        // Output: 10
        // Machine has 10 available processors (cores)
        // each core has 1 thread
        // Thus, the machine has 10 threads available to run things in parallel

        // Download a file using a runnable task -----------------------------------------------------------------------
        System.out.println("Demo 1: Download a file using a runnable task -------------------------------------------");
        demo1DownloadAFile();

        // Download 10 files concurrently ------------------------------------------------------------------------------
        System.out.println("Demo 2: Download 10 files concurrently --------------------------------------------------");
        demo2Download10FilesConcurrently();

        try {
            Thread.sleep(10_000); // Sleep for 10 seconds to allow all threads to finish their tasks
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Thread.sleep(milliseconds) ----------------------------------------------------------------------------------
        System.out.println("Demo 3: Thread.sleep(milliseconds) ------------------------------------------------------");
        demo3ThreadSleepNConcurrentExecution();

        // Thread Joining and waiting for a thread to finish -----------------------------------------------------------
        System.out.println("Demo 4: Thread Joining and waiting for a thread to finish -------------------------------");
        demo4DownloadFileAndScanForVirus();

        // Interrupting a thread ---------------------------------------------------------------------------------------
        System.out.println("Demo 5: Interrupting a thread -----------------------------------------------------------");
        demo5InterruptingAThread();

        // Race Conditions and shared resources ------------------------------------------------------------------------
        System.out.println("Demo 6: Race Conditions and shared resources --------------------------------------------");
        demo6DownloadFilesAndReportStatus();

        // Strategies for Thread Safety --------------------------------------------------------------------------------
        // =============================================================================================================

        // Strategies for Thread Safety: Confinement -------------------------------------------------------------------
        System.out.println("Demo 7: Strategies for Thread Safety: Confinement ---------------------------------------");
        demo7ConfinementToPreventRaceConditions();

        // Strategies for Thread Safety: Locks -------------------------------------------------------------------------
        System.out.println("Demo 8: Strategies for Thread Safety: Locks ---------------------------------------------");
        demo8LocksToPreventRaceConditions();

        // Strategies for Thread Safety: `synchronized` keyword --------------------------------------------------------
        System.out.println("Demo 9: Strategies for Thread Safety: `synchronized` keyword ----------------------------");
        demo9SynchronizedKeywordToPreventRaceConditions();

        // Strategies for Thread Safety: `volatile` keyword ------------------------------------------------------------
        System.out.println("Demo 10: Strategies for Thread Safety: `volatile` keyword -------------------------------");
        demo10VolatileKeywordToPreventVisibilityProblem();


        // Thread signalling with `wait()` and `notify()` methods ------------------------------------------------------
        System.out.println("Demo 11: Thread signalling with `wait()` and `notify()` methods -------------------------");
        demo11ThreadSignallingWithWaitAndNotify();

        // Strategies for Thread Safety: Atomic Types ------------------------------------------------------------------
        System.out.println("Demo 12: Strategies for Thread Safety: Atomic Types -------------------------------------");
        demo12AtomicTypesToPreventRaceConditions();

        // Strategies for Thread Safety: Adders ------------------------------------------------------------------------
        System.out.println("Demo 13: Strategies for Thread Safety: Adders -------------------------------------------");
        demo13AddersToPreventRaceConditions();

        // Collections and Threads -------------------------------------------------------------------------------------
        System.out.println("Demo 14: Collections and Threads --------------------------------------------------------");
        demo14CollectionsNThreads();

        // Strategies for Thread Safety: Syncnronied Collections -------------------------------------------------------
        System.out.println("Demo 15: Strategies for Thread Safety: Synchronized Collections -------------------------");
        demo15SynchronizedCollections();

        // Strategies for Thread Safety: Concurrent Collections --------------------------------------------------------
        System.out.println("Demo 16: Strategies for Thread Safety: Concurrent Collections ---------------------------");
        demo16ConcurrentCollections();
    }


    // Download a file using a runnable task; thread
    private static void demo1DownloadAFile() {
        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new Thread(new DownloadFileTask1());
        thread1.start();

        /* Output:
        main
        Downloading file in thread: Thread-0
         */

        // Here, we have 2 threads:
        // 1. main thread: the one that runs the main method
        // 2. Thread-0: the one that runs the DownloadFileTask2
        // Each thread starts, executes a task and then dies.
        // So, we don't have to explicitly kill the threads.
    }

    // Download 10 files concurrently using runnable tasks; threads
    private static void demo2Download10FilesConcurrently() {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask1());
            thread.start();
        }

        /* Output:
        main
        Downloading file in thread: Thread-0
        Downloading file in thread: Thread-1
        Downloading file in thread: Thread-4
        Downloading file in thread: Thread-10
        Downloading file in thread: Thread-3
        Downloading file in thread: Thread-5
        Downloading file in thread: Thread-2
        Downloading file in thread: Thread-8
        Downloading file in thread: Thread-9
        Downloading file in thread: Thread-6
        Downloading file in thread: Thread-7
         */
        // Even though these messages are appearing sequentially on the terminal,
        //      these threads starts and run in parallel.
    }

    // Demo for Thread.sleep(milliseconds) and concurrent execution of threads
    private static void demo3ThreadSleepNConcurrentExecution() {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask2());
            thread.start();
        }
        /* Output:
            main
            Downloading file in thread: Thread-16
            Downloading file in thread: Thread-14
            Downloading file in thread: Thread-12
            Downloading file in thread: Thread-18
            Downloading file in thread: Thread-19
            Downloading file in thread: Thread-20
            Downloading file in thread: Thread-17
            Downloading file in thread: Thread-15
            Downloading file in thread: Thread-11
            Downloading file in thread: Thread-13
            Download complete: Thread-15
            Download complete: Thread-18
            Download complete: Thread-16
            Download complete: Thread-14
            Download complete: Thread-12
            Download complete: Thread-19
            Download complete: Thread-13
            Download complete: Thread-11
            Download complete: Thread-17
            Download complete: Thread-20
         */

        // Here, these 10 threads start at the same time and after 5 seconds, they all complete.
    }


    // Kick off another thread to scan the downloaded file for viruses, after it is downloaded
    private static void demo4DownloadFileAndScanForVirus() {
        System.out.println(Thread.currentThread().getName());

        Thread downloadThread = new Thread(new DownloadFileTask2());
        downloadThread.start();


        // Here, we can use the join() method to wait for the download thread to finish before starting the scan thread
        try {
            downloadThread.join(); // Wait for the download thread to finish
            // This makes the current thread, which is the main thread, wait until the download thread finishes its execution
            // blocks the current thread until the download thread has finished
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("File is ready to be scanned for viruses....");

        // Now, we can start the scan thread
    }

    // Demo for interrupting a thread
    private static void demo5InterruptingAThread() {
        Thread thread = new Thread(new DownloadFileTask3());
        thread.start();

        try {
            Thread.sleep(1000); // Sleep for 1 second to allow the thread to start downloading
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // cancel thread after 1 second
        thread.interrupt();
        // .interrupt() method doesn't actually force the thread to stop,
        //      it simply sends an interrupt signal to the thread.
        // It's up to that thread to decide if it should stop what it's doing.

    }

    // Download files concurrently and report the total bytes downloaded
    private static void demo6DownloadFilesAndReportStatus() {
        // All download threads report to a single DownloadStatus1 object
        var status = new DownloadStatus1();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask4(status));
            thread.start();
            // -- A
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());

        /* Output:
        .......
        Downloading byte 9998 in thread: Thread-31
        Downloading byte 9999 in thread: Thread-31
        Download complete: Thread-31
        Total bytes downloaded: 99998
         */

    }

    // Use confinement to prevent race conditions
    private static void demo7ConfinementToPreventRaceConditions() {
        List<Thread> threads = new ArrayList<>();

        // To access downloadStatus object of DownloadFileTask4, after the for loop
        List<DownloadFileTask4> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileTask4();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        var totalBytes = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(0, Integer::sum);

        System.out.println("Total bytes downloaded: " + totalBytes);
        /* Output:
        ....
        Total bytes downloaded: 100000
         */
        // same result on each run; no longe have a race condition
    }

    // Use locks to prevent race conditions & visibility issues
    private static void demo8LocksToPreventRaceConditions() {
        // All download threads report to a single DownloadStatus2 object with locks on incrementTotalBytes() method
        var status = new DownloadStatus2();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask5(status));
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());

        /* Output:
        .......
        Total bytes downloaded: 100000
         */

    }

    // Use synchronized keyword to prevent race conditions
    private static void demo9SynchronizedKeywordToPreventRaceConditions() {
        // All download threads report to a single DownloadStatus3 object
        //      with synchronized block on incrementTotalBytes() method
        var status = new DownloadStatus3();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask6(status));
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());

        /* Output:
        .......
        Total bytes downloaded: 100000
         */
    }

    // Use volatile keyword to prevent visibility issues
    private static void demo10VolatileKeywordToPreventVisibilityProblem() {
        var status = new DownloadStatus4();

        // thread for downloading a file
        var thread1 = new Thread(new DownloadFileTask7(status));

        // thread for checking the download status
        var thread2 = new Thread(() -> { // lambda expression that represents a Runnable
            while (!status.isDone()) {
                // wait until the download is done
            }
            System.out.println("Download complete: Total Bytes " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

        /* Output:
            .....
            Download complete: Total Bytes 1000000
            Download complete: Thread-63
         */
    }

    // Thread signalling with wait() and notify() methods
    private static void demo11ThreadSignallingWithWaitAndNotify() {
        var status = new DownloadStatus4();

        // thread for downloading a file
        var thread1 = new Thread(new DownloadFileTask8(status));

        // thread for checking the download status
        var thread2 = new Thread(() -> { // lambda expression that represents a Runnable
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                        // this makes this thread to go to sleep
                        //      until another thread notifies it that the state of this status object has changed
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Download complete: Total Bytes " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

        /* Output:
            .....
            Download complete: Thread-0
            Download complete: Total Bytes 1000000
         */
    }

    // Use atomic types to prevent race conditions
    private static void demo12AtomicTypesToPreventRaceConditions() {
        // All download threads report to a single DownloadStatus5 object
        var status = new DownloadStatus5();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask9(status));
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());
        /* Output:
        ......
        Download complete: Thread-4
        Total bytes downloaded: 100000
         */
    }

    // Use adder classes to prevent race conditions
    private static void demo13AddersToPreventRaceConditions() {
        // All download threads report to a single DownloadStatus object
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());
        /* Output:
        ......
        Download complete: Thread-9
        Total bytes downloaded: 100000
         */
    }

    // Problem with multiple threads accessing a collection
    private static void demo14CollectionsNThreads() {
        Collection<Integer> collection = new ArrayList<>();

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
        /* Output:
        [4, 5, 6]
         */

    }

    // Use synchronized collections to prevent race conditions with collections
    private static void demo15SynchronizedCollections() {

        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
        /* Output:
        [1, 2, 3, 4, 5, 6]
         */

    }

    // Use concurrent collections to make collections thread-safe
    private static void demo16ConcurrentCollections() {
        // Regular HashMap is not thread-safe
        Map<Integer, String> map = new HashMap<>();
        // key: Integer, value: String

        map.put(1, "a");
        System.out.println(map.get(1));

        // Thread safe ConcurrentHashMap
        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(1, "a");
        System.out.println(concurrentMap.get(1));
    }

}
