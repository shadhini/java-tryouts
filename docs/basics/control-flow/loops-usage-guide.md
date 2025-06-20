---
icon: message-check
---

# Loops Usage Guide

In situations where you know in ahead of time that how many times you have to execute set of statements&#x20;

**``╰┈➤ use `for` loop``**

In situations where you don't know exactly how many times you want to repeat something

**``╰┈➤ use `while` loop``**

* e.g: run a program till user enter `quit`.

In situations where you don't know exactly how many times you want to repeat something, but you want the loop body to execute at least once

**``╰┈➤ use `do... while` loop``**

In situations where you simply want to iterate over array of items and don't need the access to index of each item&#x20;

**``╰┈➤ use `for each` loop``**

***

❌ Don't create unnecessary objects inside loops.

* Unless that object need to be created in every iteration, declare and create it outside the loop and reuse it inside the loop.

**`while (true)`** loops must have a `break` statement

* They are dangerous in terms of memory consumption.



