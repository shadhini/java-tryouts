---
icon: capsules
---

# Encapsulation

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



### Benefits:&#x20;

* If we need the same functionality of a class/ methods of that class in another project, we can simply copy the class or put it in a reusable library \[most recommended] .



{% content-ref url="https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/oop/encapsulation/getters-and-setters" %}
[Getters and Setters](https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/oop/encapsulation/getters-and-setters)
{% endcontent-ref %}



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/d5f69f2215554107d87e5e0666da22ca2fc3630a/oop/src/com/shadhini/java/tryouts/oop/encapsulation/Main.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/a5bce2c44dac9094e79126048fc91fcaa2427a71/oop/src/com/shadhini/java/tryouts/oop/encapsulation/Employee.java" %}



## Getters and Settters

{% content-ref url="getters-and-setters.md" %}
[getters-and-setters.md](getters-and-setters.md)
{% endcontent-ref %}



<table data-view="cards"><thead><tr><th></th><th data-hidden data-card-target data-type="content-ref"></th></tr></thead><tbody><tr><td><strong>Getters and Setters</strong>     </td><td><a href="getters-and-setters.md">getters-and-setters.md</a></td></tr></tbody></table>

