---
icon: object-exclude
---

# Combining Completable Futures

## Combining Completable Futures

**— Start 2 tasks asynchronously and then combine the results. —**&#x20;

E.g:

* Say we call a remote service to get the price of a product and that service returns the price in USD
* At the same time, in parallel we want to call another service to get the exchange rate between USD and LKR.&#x20;
* We don't want to call the second service upon completion of the first task; we want to start 2nd task concurrently and then wait for both of them to complete in order to calculate the value of product in LKR.



{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.thenCombine(CompletionStage, BiFunction)`:&#x20;
  * combine the result of 2 asynchronous operations, so we can wait both of them to complete to calculate the final result
  * calling this method is not going to block the current thread, we are basically building a processing pipeline
  * 1st parameter of type `CompletionStage` --> the 2nd task
  * 2nd parameter of type `BiFunction` --> a function with 2 parameters that returns a value; these parameters represent the results produced by 1st and 2nd task respectively
  * this method will return a new CompletableFuture object
{% endhint %}



```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        // running multiple tasks at the same time and then combine the results
        var firstTask = CompletableFuture.supplyAsync(() -> 20); // retrieve price of the item
        var secondTask = CompletableFuture.supplyAsync(() -> 300); // retrieve exchange rate USD to LKR
        firstTask
            .thenCombine(secondTask, (price, exchangeRate) -> price * exchangeRate) // combine the results of the two tasks
            .thenAccept(totalPrice -> System.out.println("Total price in LKR: " + totalPrice));
        // Output: Total price in LKR: 6000
    }
}
```

Here, we are telling the `Executor` to start these 2 tasks concurrently and when they are both complete, start a new task to do something else. All of this is happening asynchronously&#x20;



#### If the first task returns the price as a String "20USD"

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        // if first task returns the price as a String
        var firstTask = CompletableFuture
                .supplyAsync(() -> "20USD") // retrieve price of the item
                .thenApply(str -> { // convert the price to an Integer
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                }); 
        var secondTask = CompletableFuture.supplyAsync(() -> 300); // retrieve exchange rate USD to LKR
        firstTask
                .thenCombine(secondTask, (price, exchangeRate) -> price * exchangeRate) // combine the results of the two tasks
                .thenAccept(totalPrice -> System.out.println("Total price in LKR: " + totalPrice));
        // Output: Total price in LKR: 6000
    }
}
```

All of this is happening asynchronously. So none of this code is going to block the current /main thread.

