---
icon: c
---

# Classes

## Classes

✅  ✨ A class should have only a single responsibility.

✅️  Extract repetitive patterns and highly related statements into methods and classes.

✅ Keep everything that's not needed outside as private members.



✅  ✨

> **private fields**/data members&#x20;
>
> **public setter** methods with field **data validation** logic to set values for these fields&#x20;
>
> **public getters**; if it is necessary to access the data field values



❗ An abstract class does not need abstract methods. But if we mark a method as abstract, we should mark the class as abstract as well.

### Organization of the Class Declaration

1. Fields
2. Constructors
3. Public Methods
4. Getters and Setters

### Methods

✅ Logically related methods should be defined next to each other for better organisation of code.

✅  ✨ Less methods in class & Private methods -> Hide implementation -> Reduce Coupling -> Reduce impact of changes

❗ Frequently changing values should be method parameters instead of class's fields.

✅ Move all the getters and setters to the bottom of the class.

ℹ️ In complex applications, we are not going to declare getters and setters for every field. One method declared might change few fields.



✅ Add `@Override` annotation for methods inherited from the implemented interface/s.

#### Parameters

❗ Frequently changing values should be method parameters instead of class's fields.



### Fields&#x20;

❗In Java we should **not** declare fields as **public**. They should be **private**.

✅ Define repeated constants on methods @ class level as final variables. Make them final static if variables belong to the class.

### Fields & Constructors

✅ Interface of a class should be as simple as possible. You should reduce the **`guess work`**.

✅️ Make sure fields of a class are initialised in the **`constructors`**.

* ❌ We don't initialise values in a class as it is only a blueprint.&#x20;
* ✅️  Instead, when later objects are created, field values should be set for each object.
* ✅ Setters can be called inside the constructor to put an object created on a valid state from the beginning.
* ❌ An object shouldn't go to an `invalid state` after creation.
* If we don't initialise a variable of `Reference Type`, they are set to **`null`**. i.e. it doesn't reference a real object in memory.
* ❗ `Nulls` are dangerous, they can crash programs with **`java.lang.NullPointerException.`**

❗ Frequently changing values should be method parameters instead of class's fields.



