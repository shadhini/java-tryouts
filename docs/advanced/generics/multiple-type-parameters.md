---
icon: people
---

# Multiple Type Parameters

## Methods with multiple type parameters

```java
public class Utils {
    // Generic method with multiple type parameters
    public static <K, V> void print(K a, V b) {
        System.out.println(a + " = " + b);
    }
}

public class Main {
    public static void main(String[] args) {
        Utils.print(1, "hello");
    }
}
```

<div>

<figure><img src="../../.gitbook/assets/java-ad-generics-10-generic-methods-multi-param-1.png" alt=""><figcaption></figcaption></figure>

 

<figure><img src="../../.gitbook/assets/java-ad-generics-10-generic-methods-multi-param-2.png" alt=""><figcaption></figcaption></figure>

</div>

## Classes with multiple type parameters

```java
public class KeyValuePair<K,V> {

    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
```



