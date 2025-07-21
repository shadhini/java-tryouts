---
icon: octagon-minus
---

# Confinement

## Confinement

> **— confine or restrict each thread to have its own data —**&#x20;
>
> * not share data across threads in the first place

### Example: reporting download status of multiple concurrent downloads

Instead of sharing a `downloadStatus` object across many download tasks, you could have each download task have its own `downloadStatus` object.&#x20;

When all these tasks are complete, we can **combine the result**.



```java
public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        totalBytes++;
    }
}

public class DownloadFileTask implements Runnable {

    private final DownloadStatus status;

    public DownloadFileTask() {
        this.status = new DownloadStatus();
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

    public DownloadStatus getStatus() {
        return status;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        // To access downloadStatus object of DownloadFileTask, after the for loop
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
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
    }
}
```



Now, with this program we always gets 100,000 as the totalyBytes. We no longer have a race condition  as these threads are not modifying a shared object.

