---
icon: capsules
---

# Encapsulation

## Encapsulation

> **Encapsulation**:
>
> Bundle the&#x20;
>
> 1. **`data`** and
> 2. **`methods`** that operate on the data
>
> in a **`single unit`**; object.

Instead of passing values around we should encapsulate these values along with the methods that operate on them inside a single object.



❌  We don't initialise values in a class as it is only a blueprint.

✅️  Instead, when later objects are created, field values should be set for each object.

❗ Frequently changing values should be method parameters instead of class's fields.



## Getters and Setters

{% content-ref url="getters-and-setters.md" %}
[getters-and-setters.md](getters-and-setters.md)
{% endcontent-ref %}



## Benefits

* If we need the same functionality of a class/ methods of that class in another project, we can simply copy the class or put it in a reusable library _`[most recommended]`_ .



## Example

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/encapsulation/Employee.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/encapsulation/Encapsulation.java" %}



