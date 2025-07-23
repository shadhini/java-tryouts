package com.shadhini.tryouts.java.advanced.executive_framework.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

// Demonstrates the use of the Executors framework to manipulate threads
public class ExecutorsDemo {

    public static void main(String[] args) {

        // Create a thread pool using the Executor framework -----------------------------------------------------------
        // =============================================================================================================
        System.out.println("Creating a thread pool using the Executor framework -------------------------------------");
        createThreadPool();

        // Submit Runnable tasks to a thread pool using the Executor framework -----------------------------------------
        // =============================================================================================================
        System.out.println("Submitting Runnable tasks to a thread pool using the Executor framework------------------");
        submitRunnableTasksToThreadPool();

        // Submit Callable tasks to a thread pool using the Executor framework -----------------------------------------
        // =============================================================================================================
        System.out.println("Submitting Callable tasks to a thread pool using the Executor framework------------------");
        submitCallableTasksToThreadPool();
    }


    // create a thread pool using the Executor framework
    private static void createThreadPool() {
        var executor = Executors.newFixedThreadPool(2); // thread pool with 2 worker threads
        // Here, the executor is of type java.util.concurrent.ExecutorService interface
        // At runtime, it will be an instance of java.util.concurrent.ThreadPoolExecutor class

        System.out.println(executor.getClass().getName());
        // Output: java.util.concurrent.ThreadPoolExecutor

        executor.shutdown(); // shutdown the executor
    }

    // Submit Runnable tasks to a thread pool using the Executor framework
    private static void submitRunnableTasksToThreadPool() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            // Submit tasks to the executor; to the thread pool
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " is executing task A"));
            // Here, we didn't have to explicitly create a thread
            // Output: pool-1-thread-1 is executing task A

            // We have only 2 threads available, and we are submitting 10 tasks below
            for (var i = 1; i < 11; i++) {
                final int taskId = i;
                executor.submit(() -> System.out.println(Thread.currentThread().getName() + " is executing task " + taskId));
            }
        /* Output:
        pool-1-thread-2 is executing task 1
        pool-1-thread-1 is executing task 2
        pool-1-thread-2 is executing task 3
        pool-1-thread-1 is executing task 4
        pool-1-thread-2 is executing task 5
        pool-1-thread-1 is executing task 6
        pool-1-thread-2 is executing task 7
        pool-1-thread-1 is executing task 8
        pool-1-thread-2 is executing task 9
        pool-1-thread-1 is executing task 10
         */
            // Internally, this executor maintains a queue to hold the tasks
        }
        finally {
            executor.shutdown(); // shutdown the executor; no new tasks will be accepted
        }
    }

    // Submit Callable tasks to a thread pool using the Executor framework
    private static void submitCallableTasksToThreadPool() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                LongTask.simulate(); // Simulate a long-running task
                return 1; // Callable task returns a value
            });
            // Here, the output of the task is captured in a Future object

            System.out.println("Do more work........");

            try {
                var result = future.get(); // get the result from Future object, when we really need it
                System.out.println("Result from Callable task: " + result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        finally {
            executor.shutdown();
        }
    }


}
