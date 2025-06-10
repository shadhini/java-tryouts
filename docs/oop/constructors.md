---
icon: person-digging
---

# Constructors

> ❗**Used to initialise instances.**
>
> **A special method that is called when we create/construct a new object.**
>
> -> Reduce guess work when initialising an object to valid state by initialising fields in the constructor.

## Need for Constructors

* If an object goes to an `invalid state`, without calling some setters to set attributes after creation of object -> then it's **bad design**.
* We need to keep objects in an `initial valid state` when it's created.



* We don't wanna force consumers of classes to use that in a particular way.
* It's like having a magical remote control that forces you to press `A` and then `B` before changing a channel.
* We need to make the interface of class as simple as possible -> need to reduce the guess work.



## Default Constructor

> **Job of default constructor is to initialise the fields of the class to default values.**

╰┈➤ numbers -> `0`

╰┈➤ booleans -> `false`

╰┈➤ reference types -> `null`

<pre class="language-java"><code class="lang-java">public class Employee { // no parameters
    public <a data-footnote-ref href="#user-content-fn-1">Employee</a>() {
    }
}
</code></pre>

This default constructor is automatically added by `Java Compiler` if we haven't create any constructors.&#x20;

* Thus, there's no need to add it to the code.



## Constructors

<pre class="language-java"><code class="lang-java">public class &#x3C;CLASS_NAME> {
    <a data-footnote-ref href="#user-content-fn-2">public &#x3C;CLASS_NAME>(&#x3C;PARAMETER_LIST>)</a> {
    }
}
</code></pre>

* Constructors don't have a return type; not even `void`.

❗ We need to initialise the fields  within the constructor based on the parameters we receive.&#x20;



## Example

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/a017ce7db15253192612b4a35f7a070487fec4df/oop/src/com/shadhini/java/tryouts/oop/constructors/Main.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/a017ce7db15253192612b4a35f7a070487fec4df/oop/src/com/shadhini/java/tryouts/oop/constructors/Employee.java" %}





[^1]: \<CLASS\_NAME>

[^2]: constructor
