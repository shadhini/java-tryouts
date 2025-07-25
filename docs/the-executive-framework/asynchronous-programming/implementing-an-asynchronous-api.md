---
icon: bell-concierge
---

# Implementing an Asynchronous API

## Implementing an Asynchronous API

Anytime we have a long running operation like&#x20;

* querying a database,&#x20;
* calling a remote service,&#x20;
* working with the file system

╰┈➤ we should **run these operations `asynchronously`**.



#### Asynchronous Method Naming Convention

We should add the `Async` postfix to method name:

* E.g: sendAsync(), getAsync()



#### Synchronous Code

```java
public class LongTask {

    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class MailService {

    // synchronous mail sending service
    public void send() {
        // a long running task
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }
}
```

```java
// Synchronous or blocking code
// This code will block the main thread until the mail is sent
// The "Hello, world!" message will not be printed until the mail sending task is completed
public class SynchronousAPIDemo {
    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.send();
        System.out.println("Hello, world!");
        /* Output:
            Mail was sent.
            Hello, world!
         */
    }
}
```

#### Asynchronous Code

When we call `CompletableFuture.runAsync(Runnable)`, the task we pass here is going to be executed on a separate thread on the common thread pool.

You can convert an existing synchronous method to an asynchronous method by wrapping the synchronous method inside a `CompletableFuture` object.

```java
public class LongTask {

    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

```java
import java.util.concurrent.CompletableFuture;

public class MailService {

    // synchronous mail sending service
    public void send() {
        // a long running task
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    // asynchronous mail sending service
    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(this::send);
    }
}

// Asynchronous API demo
public class AsynchronousAPIDemo {

    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.sendAsync();
        System.out.println("Hello, world!");
        /* Output:
            Hello, world!
         */

    }
}
```

Here, we what we have is a command line program and this program terminates too quickly that we didn't see the result of this asynchronous task that was executed on a separate thread.&#x20;

But, we won't have this problem in a mobile or a desktop app, as these apps are continuously running until the user terminates them.&#x20;



```java
public class AsynchronousAPIDemo {

    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.sendAsync();
        System.out.println("Hello, world!");

        try {
            Thread.sleep(5000); // wait for the async task to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        /* Output:
            Hello, world!
            Mail was sent.
        */

    }
}
```

If we `sleep()` the main thread for 5 seconds as above, then we can see the result of the asynchronous task.



