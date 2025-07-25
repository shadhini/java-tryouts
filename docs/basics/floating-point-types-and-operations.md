---
icon: input-numeric
---

# Floating-point Types and Operations

## Floating-point Types

```java
float price = 10.99F;
double a =. 1.0;
```

## Floating-point Numbers with a Mantissa

```java
double eps = 5e-3; // means 5 * 10^(-3) = 0.005
double n = 0.01e2; // means 0.01 * 10^2 = 1.0
```



## Errors During Computations with Floating-point Numbers

```java
System.out.println(3.3 / 3); // prints 1.0999999999999999
```

Errors can accumulate during computation.

```java
double d = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
System.out.println(d); // prints 0.9999999999999999
```

#### Reason

Floating point numbers are **stored and operated in binary form** and **not all real numbers can be represented exactly**.





