---
icon: timeline-arrow
---

# Composing Completable Futures for Task after Task

## Composing Completable Futures for Task after Task

Quite often we want to start a task upon completion of another task.

E.g:&#x20;

* Say, we have the id of a user, and we want to get the user's email.&#x20;
* So, we have to go to our database and read that user record.
* With this, we can get their email.
* Now, we want to pass this email to one of those music streaming websites where people have their own playlists.&#x20;
* So, we pass the email and get the playlist for a given person.

So, here we have, 2 tasks; 2 asynchronous operations and we want to start the second task upon the completion of first task.

CompletableFutures make it easy implement this kind of scenarios.

{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.thenCompose(Function<? super T, ? extends CompletionStage<U>)`:&#x20;
  * from the Function passed here we should return a new CompletableFuture that represents a new asynchronous task
  * returns a new CompletableFuture that is same as the one returned from the given Function
  * executed using the main thread
* `.thenComposeAsync(Function<? super T, ? extends CompletionStage<U>)`:&#x20;
  * executed using this stage's default asynchronous execution facility
{% endhint %}



```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        // id -> email
        // email -> playlist
        // Option 1
        CompletableFuture.supplyAsync(() -> "email") // operation to get the email for given id
            .thenCompose(email -> CompletableFuture.supplyAsync(() -> "playlist for " + email)) // operation to get the playlist for given email
            .thenAccept(playlist -> System.out.println("Playlist: " + playlist));

        // Option 2: similar to real world scenario
        getUserEmailAsync(1) // id -> email
                .thenCompose(CompletableFuturesDemo:: getUserPlaylistAsync) // email -> playlist
                .thenAccept(playlist -> System.out.println("Playlist: " + playlist));
    }
}
```

