---
icon: shovel
---

# Constructor Injection

## Constructor Injection

> **Pass a dependency via the constructor of the class.**

This is the most common dependency injection approach.

* Bcz with this approach we can see dependencies of a class at a glance.

## Example

Here `TaxReport` talk to the interface; not to a concrete implementation -> **no coupling**\
`Tax Report` doesn't know anything about the concrete implementation\
<kbd>**==> Programming against Interfaces**</kbd>

Even if implementation of method in TaxCalculator2024 class changes, `TaxReport`  class doesn't need to be recompiled. Since this doesn't depend on it.\
<kbd>**==> Loose coupling**</kbd>



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/dependency_injection/loosely_coupled/constructor_injection/TaxCalculator.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/dependency_injection/loosely_coupled/constructor_injection/TaxCalculator2024.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/dependency_injection/loosely_coupled/constructor_injection/TaxReport.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/dependency_injection/loosely_coupled/constructor_injection/ConstructorInjection.java" %}





