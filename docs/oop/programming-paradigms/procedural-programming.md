---
icon: stairs
---

# Procedural Programming

> **about procedures and function calls**
>
> Have
>
> * bunch of **`variables`** and
> * bunch of functions called **`procedures`**



## Characteristics of code written in procedural style

*   **Methods that have many parameters**

    * If you are constantly calling methods and passing arguments, that means you're doing procedural programming.


*   **Fat methods/ classes**

    * Programs written this way are very hard to maintain.
    * If something goes wrong, you have to go all over the place to figure out what to change &#x20;
    * When you change, there will be so many other things that needs to be changed. It can introduce  many bugs to the program.


*   **Lack of reusability**

    * There will be many functions and if you want to reuse them in other programs, you'll have to copy some code from here, some code from there.
    * And then you might not be able to put them together because their parameters are different.


* **Messy | `Spaghetti Code`**
  * Everything is interconnected with each other.
  * It's hard to extend/ maintain such code.



## Example Implementation of Mortgage Calculator using Procedural Paradigm&#x20;

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/70167d9b175908b6a08a9a53fa92b24b2f5f5802/tools/mortgage-calculator/src/com/shadhini/java/tryouts/tools/procedural/MortgageCalculator.java" %}



