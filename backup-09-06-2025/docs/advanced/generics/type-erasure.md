---
description: How generic classes work under the hood
icon: delete-left
---

# Type Erasure

> **`Type Erasure`** -> **Java compiler erases type parameters and replaces them with a class or interface depending on the constraints.**
>
> If there are no constraints, all these T's are replaced with the Object class.

## Internal Implementation of Generics without extends

If you examine the byte code of the following, you'll see that Java compiler **`replace all these T's with Object type`**.

i.e Internally this Generic class is implemented like the non generic class we implemented in [Need for Generics: Poor Solution](need-for-generics.md#poor-solution) section.

The difference between this implementation and the `Poor Solution` is the **`Compile Time Type Safety`**. So, when you uses the `generic` implementation, Java Compiler will check for type errors at compile time. But internally all different types of our objects are stored in an array of `Object` type.

```java
public class GenericList<T> {
    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
```

<pre><code>...
// signature &#x3C;T:Ljava/lang/Object;>Ljava/lang/Object;
// declaration: com/shadhini/java/tryouts/advanced/generics/GenericList&#x3C;T>
public class com/shadhini/java/tryouts/advanced/generics/GenericList {

  // compiled from: GenericList.java
  
...
  // declaration: items extends T[]
  private [<a data-footnote-ref href="#user-content-fn-1">Ljava/lang/Object; items</a>

...

  // declaration: void add(T)
  public <a data-footnote-ref href="#user-content-fn-2">add(Ljava/lang/Object;)V</a>
   
...
  // declaration: T get(int)
  public <a data-footnote-ref href="#user-content-fn-3">get(I)Ljava/lang/Object;</a>
  
...
</code></pre>



## Internal Implementation of Generics with one constraint

When constraint is added to the type parameter of generic class, Java compiler will replace all the T's based on the constraint we have set.&#x20;

When the type parameter of a generic class is extended by a class or interface, as shown in the byte code of the following example, all occurrences of `T` are replaced with the extended class/interface by the Java compiler.

```java
public class GenericList<T extends Number> {
    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
```

<pre><code>...
// signature &#x3C;T:Ljava/lang/Number;>Ljava/lang/Object;
// declaration: com/shadhini/java/tryouts/advanced/generics/GenericList&#x3C;T extends java.lang.Number>
public class com/shadhini/java/tryouts/advanced/generics/GenericList {

  // compiled from: GenericList.java
  
...
  // declaration: items extends T[]
  private <a data-footnote-ref href="#user-content-fn-4">[Ljava/lang/Number; items</a>

...
  // declaration: void add(T)
  public <a data-footnote-ref href="#user-content-fn-5">add(Ljava/lang/Number;)V</a>

...
  // declaration: T get(int)
  public <a data-footnote-ref href="#user-content-fn-6">get(I)Ljava/lang/Number;</a>
   
...
</code></pre>



## Internal Implementation of Generics with multiple constraints

When constraints are added to the type parameter of generic class, Java compiler will replace all the T's based on the left most constraint we have set.&#x20;

When the type parameter of a generic class is extended by multiple interfaces, as shown in the byte code of the following example, all occurrences of `T` are replaced with the left most interface by the Java compiler.

```java
public class GenericList<T extends Comparable & Cloneable> {
    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}
```

<pre><code>...
// signature &#x3C;T::Ljava/lang/Comparable;:Ljava/lang/Cloneable;>Ljava/lang/Object;
// declaration: com/shadhini/java/tryouts/advanced/generics/GenericList&#x3C;T extends java.lang.Comparable, java.lang.Cloneable>
public class com/shadhini/java/tryouts/advanced/generics/GenericList {

  // compiled from: GenericList.java

...
  // declaration: items extends T[]
  private <a data-footnote-ref href="#user-content-fn-7">[Ljava/lang/Comparable; items</a>

...
  // declaration: void add(T)
  public <a data-footnote-ref href="#user-content-fn-8">add(Ljava/lang/Comparable;)V</a>

...
  // declaration: T get(int)
  public <a data-footnote-ref href="#user-content-fn-9">get(I)Ljava/lang/Comparable;</a>
   
...
</code></pre>

[^1]: items field

[^2]: Declaration of add() method

[^3]: declaration of get() method

[^4]: items field declaration

[^5]: add() method declaration

[^6]: get() method declaration

[^7]: items field declaration

[^8]: add() method declaration

[^9]: get() method declaration
