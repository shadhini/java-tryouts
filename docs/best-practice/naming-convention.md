---
icon: pen-field
---

# Naming Convention

[Reserved keywords](../basics/reserved-keywords.md) cannot be used to name variables, methods and classes.

## Method Names

* **`camelNamingConvention`**: first letter of every word should be uppercase except the first word
* proper descriptive names &#x20;
* clearly identifies the purpose of the method

e.g:

```
sendEmail()
```

## Class Names

* **`PascalNamingConvention`**: first letter of every word should be uppercase



## Interface Names

* **`PascalNamingConvention`**: first letter of every word should be uppercase
* In C# we prefixes interfaces with capital `I` to indicate that it is an interface.&#x20;
  * But this convention is not popular in Java.&#x20;
* In Java,
  * we sometimes use `Can` prefix.
    * e.g: CanCalculateTax
  * use `able` postfix
    * e.g: Draggable, Resizable



## Variable Names

* **`camelNamingConvention`**: first letter of every word should be uppercase except the first word

### If the variable is a constant; a final static variable,

* UPPERCASE: all uppercase letters are used and words are separated with underscores (`_`)

```
MAXIMUM_INTEREST_RATE
```



## Fields

* **`camelNamingConvention`**: first letter of every word should be uppercase except the first word



## Custom Exception Classes

* **`PascalNamingConvention`**: first letter of every word should be uppercase
* use **`Exception`** postfix always&#x20;
