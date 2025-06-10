---
icon: list
---

# Declarative Programming

> **Specifies `what` needs to be done**, instead of specifying how it should be done
>
> ╰┈➤ express logic in terms of what needs to be done

In declarative programming, instead of using instructions to specify how something should be done,  what needs to be done is specified.

e.g:&#x20;

```java
import java.util.List;
import java.util.function.Function;

public class LambdasDemo {
    public static void main(String[] args) {
    
        List<Integer> list = List.of(1, 2, 3);
        
        // Declarative Programming
        list.forEach(item -> System.out.println(item));
        // Here we don't have a for statement; 
        //     we are simply saying for each item in this list, print it


        // 2 transformations
        /*
        input: string (e.g: "key:value")
        1st transformation: replace colon with equal sign (e.g: "key=value")
        2nd transformation: add braces around the string (e.g: "key=value")
         */
        Function<String, String> replaceColonWithEqual = str -> str.replace(":", "=");
        Function<String, String> surroundWithCurlyBraces = str -> "{" + str + "}";
        
        // Declarative Programing
        var value = replaceColonWithEqual.andThen(surroundWithCurlyBraces).apply("key:value");
        System.out.println(value);
        
        
    }
}
```

