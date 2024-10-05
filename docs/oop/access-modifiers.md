---
icon: shield-check
---

# Access Modifiers

> **`public`** -> accessible from anywhere
>
> **`private`** -> not accessible outside the class
>
> **`protected`** -> public inside the package and accessible from child classes
>
> **`default`** \[no access modifier] -> package private; public inside the package,  private outside the package
>
>
>
> \[`Recommendation`]: Use only **`public`** and **`private`** access modifiers



* **`public`** -> accessible from anywhere
* **`private`** -> not accessible outside the class
  * private fields and methods are not inherited by sub classes
  * used to hide implementation details of a class so that we can change the implementation later without impacting other classes
* **`protected`** -> public in their package and accessible from child classes
  * \[not recommended to use] makes it hard to maintain code
  * as long as we are accessing it from the same package, those members are treated like public
  * also accessible from child classes in different packages
* **`default`** \[no access modifier] -> package private; public anywhere inside the package, but private everywhere outside the package
  * default access modifier is applied when no access modifier is present
  * \[not recommended to use] it is confusing
  * even classes in other packages will not be able to inherit these members

