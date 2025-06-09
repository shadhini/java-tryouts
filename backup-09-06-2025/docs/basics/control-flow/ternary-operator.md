---
icon: t
---

# Ternary Operator

> VARIABLE **`= (`**&#x43;ONDITIO&#x4E;**`) ?`** EXPRESSION\_TRUE **`:`** EXPRESSION\_FALSE`;`



Requirement:

* income > 100,000 -> first class
* &#x20;                         else -> economy class

```java
int income = 120_000;
String className;
if (income > 100_000)
    className = "First";
else
    className = "Economy";
```

⬇

```java
int income = 120_000;
String className = "Economy";
if (income > 100_000)
    className = "First";
```

⬇

\[most professional version with ternary operator]

```java
int income = 120_000;
String className = (income > 100_000) ? "First" : "Economy";
```

