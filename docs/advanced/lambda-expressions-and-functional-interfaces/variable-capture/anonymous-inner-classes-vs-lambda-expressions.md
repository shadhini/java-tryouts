---
icon: v
---

# Anonymous Inner Classes vs Lambda Expressions

## Anonymous Inner Classes vs Lambda Expressions

|                           Anonymous Inner Classes                          |                                                                       Lambda Expressions                                                                      |
| :------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------------------------------------: |
| `this` keyword reference the current instance of the anonymous inner class |                                              `this` keyword in lambda expression references the enclosing object                                              |
|                        represents an anonymous class                       |                                                                represents an anonymous function                                                               |
|           can have state (i.e they can have fields to store data)          | cannot have fields; we can only access the local variables declared in the enclosing object  as well as the static and instance fields in the enclosing class |

