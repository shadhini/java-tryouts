---
icon: hashtag
---

# Hash Tables

## Hash Tables

> A data structure that allows to **`search`** for an object in a collection with `one computation in`` `**`O(1)`**` ``time`.

The following approach to find a specific element with specific attribute is not scalable. Because the more items in the list the more time it is going to take for searching.

```java
List<Customer> customers = new ArrayList<>();
// Find customer with specific email
for (var customer : customers)
    if (customer.getEmail() == "e1")
        System.out.println("Found!");
```

In the worst case, if the customer we are looking for is at the end of the list, we have to iterate the entire list to find that customer.&#x20;

╰┈➤ Thus the `time complexity` of this approach is **`O(n)`**; n is the number iof items in the list.

* If the list has 1M customers, and if the customer we are looking for is at the end of the list, then it's going to need 1M comparisons to find the customer we are interested in.&#x20;
  * Cost -- O(1 000 000)
* The cost of this algorithm increases **`linearly`**. in direct proportion with the size of the input.

This is where **`Hash Tables`** comes to rescue.

* The way hash tables store data is different from how List/ArrayList stores data.
* Because of that, with hash table we can quickly look for an object irrespectiveof how many items we have stored in the hash table.
* Whether we have stored 100 customers or 1,000,000 customers, we can find the customer we are looking for with just **`1 computation`**.
* i.e. It has **`O(1)`** `time complexity`.
  * There is not comparison involve when we look up for item in hash table. It's a small computation step.

In Java, the **`Map`** interface represents a **`Hash Table`**.

* In C# -> Dictionary
* In Python -> Dictionary
* In JavaScript -> Objects
  * `var person = { name: "a" }` If we create an object like this, then it's represented using a hash table under the hood in JavaScript.

