---
icon: rotate-exclamation
---

# Refactoring

> **Changing the structure of the code, without changing it's behaviour.**

**1) Extract repetitive patterns**

e.g: how user input is validated

**2) Extract highly related statements**&#x20;

lines of code / concepts that always go together

e.g: parts of values need to calculate mortgage and how they are calculated





✅ Extract repetitive patterns and highly related statements into methods and classes.

✅ Logically related methods should be defined next to each other for better organisation of code.

✅ Define repeated constants on methods @ class level as final variables. Make them final static if variables belong to the class.



### Problem with `repetition/duplication` of code&#x20;

Problem arise when we need to modify the code.

i.e. If we have repeated same lgic in multiple places, then if we ever need to change that logic, we'll have to modify it in multiple places.

If a logic never changes and amount of duplication is little -> then that duplication is not too bad.

