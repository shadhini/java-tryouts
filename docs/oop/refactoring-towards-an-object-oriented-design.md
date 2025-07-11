---
icon: send-back
---

# Refactoring Towards an Object Oriented Design

\[`Recommended`] ✅ Use an IDE  for refactoring instead of manual refactoring.



What are the classes?

* Make sure each class has a single responsibility.



ℹ️ `Constructors` are used to initialise instances.

ℹ️ `Static members` are used only when we need a single instance.

ℹ️ `Final variables` -> cannot change once set



✅ Move all the getters and setters to the bottom of the class.

✅ Keep everything that's not needed outside as private members.



## E.g: Mortgage Calculator

<div><figure><img src="../.gitbook/assets/MortgageCalc-output-1 (1).png" alt=""><figcaption></figcaption></figure> <figure><img src="../.gitbook/assets/MortgageCalc-output-2.png" alt=""><figcaption></figcaption></figure></div>

{% @github-files/github-code-block url="https://github.com/shadhini/software-architecture/blob/main/programming-paradigms/com/shadhini/tryouts/softwarearchitecture/programmingparadigms/oop/Console.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/software-architecture/blob/main/programming-paradigms/com/shadhini/tryouts/softwarearchitecture/programmingparadigms/oop/MortgageCalculator.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/software-architecture/blob/main/programming-paradigms/com/shadhini/tryouts/softwarearchitecture/programmingparadigms/oop/MortgageReport.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/software-architecture/blob/main/programming-paradigms/com/shadhini/tryouts/softwarearchitecture/programmingparadigms/oop/Main.java" %}











