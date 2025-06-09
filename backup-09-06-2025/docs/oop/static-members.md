---
icon: chart-scatter-3d
---

# Static Members

> **instance members** -> belong to the instance/object
>
> **static members** -> belong to the class

In OOP, a class can have 2 types of members;

1. **`instance members`**: belong to instances / objects
   * non static fields, non static methods belong to each instance of the class
   * We can access these members with **`.`** operator on an created object.
2. **`static/ class members`**: belong to a class not an object
   * We can access static members with **`.`** operator on class. We don't have to create an object to access them.
   * Used when we need a single instance.
   * Used when a value is independent of objects and we wanna show it across all objects and in situations where we wanna represent a concept that should be in a single place.
     * e.g: # of employees -> this does not belong to each individual employee
   * Static members can only see other static members of other classes.
   * Non static methods can access static fields; constants.
   * Static methods can access only static variables.



e.g:

* The `System` class has bunch of static members.
  * `out` -> static field
* `Integer.parseInt()` -> static method



## main() method of Main class

`main()` method of `Main` class is declared as **`static`** to enable the Java Runtime to dorectly call this method without having to create a new object.





## Example

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/342adcd12be38a038fd2f883c9690742795386a1/oop/src/com/shadhini/java/tryouts/oop/static_members/Main.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/0d3dd1e23d9bba2f94f4ac04ea5155cf920facb8/oop/src/com/shadhini/java/tryouts/oop/static_members/Employee.java" %}



