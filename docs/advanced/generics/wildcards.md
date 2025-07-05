---
icon: question
---

# Wildcards

## Wildcards

```java
public class GenericList<T> {
    private T[] items =  (T[]) new Object[10];
    private int count;

    public void add(T item) {
        items[count++] = item;
    }

    public T get(int index) {
        return items[index];
    }
}

public class User {
    private int points;

    public User(int points) {
        this.points = points;
    }
}

public class Instructor extends User {
    public Instructor(int points) {
        super(points);
    }
}

public class Utils {

    // GenericList of User
    public static void readUsersV1(GenericList<User> users) {
        User x = users.get(0);
        Instructor y = (Instructor) users.get(0); 

        users.add(new User(1));
        users.add(new Instructor(12));
        // Can't pass list of Instructor to this method as an argument, But can add an Instructor to the list
        // If Java allowed you to pass a GenericList<Instructor> to this method,
        //      you could accidentally add a User (who is not an Instructor)
        //      to a list that is supposed to contain only Instructor objects, breaking type safety.
    }

    // GenericList of any specific type
    // class CAP#1 {}
    public static void readUsersV2(GenericList<?> users) {
        Object x = users.get(0);
        User y = (User) users.get(0); // Unsafe cast: no relationship between User and CAP#1(anonymous) class

        users.add(null);
        // users.add(new Object()); // Compile time error: required type: capture of ?
        // users.add(new User(1)); // Compile time error: required type: capture of ?
        // users.add(new Instructor(12)); // Compile time error: required type: capture of ?
        // Here, GenericList<?>` is a list of an unknown type.
        // The wildcard `?` means "some specific type, but we don't know which."
        // Therefore, you cannot safely add any object (not even a `User` or `Instructor`) to it,
        //      because the compiler cannot guarantee type safety.
        // The only thing you can add to a `GenericList<?> is null.
    }

    // GenericList of any specific subtype of User
    //class CAP#1 extends User {}
    //class Instructor extends User {}
    public static void readUsersV3(GenericList<? extends User> users) {
        User x = users.get(0);
        Instructor instructor = (Instructor) users.get(0); // Unsafe cast: no relationship between Instructor and CAP#1(anonymous) class
        
        // users.add(new User(1)); // Compile time error: required type: capture of ? extends User
        // users.add(new Instructor(12)); // Compile time error: required type: capture of ? extends User
        // Here, you cannot add any object (except null) to a collection declared with ? extends User.
        // The compiler does not know the exact subtype of User the list holds,
        //      so adding a User or Instructor is unsafe.
    }

    // GenericList of User and/or any of its subtypes
    //CAP#1 == parent of User {}
    //class Instructor extends User {}
    public static void addUsers(GenericList<? super User> users) {
        Object x = users.get(0);
        User y = (User) users.get(0); // Safe cast
        Instructor instructor = (Instructor) users.get(0); // Safe cast

        users.add(new User(1));
        users.add(new Instructor(12));

        // users.add(new Object()); // Compile time error: required type: capture of ? super User
        //Here, you cannot add an Object because the list could be of type User or any of its subtypes,
        //  but not necessarily Object.
        //  Only User and its subclasses are allowed
    }  
    
}

public class Main {

    public static void main(String[] args) {
        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();

        // Without wildcards
        // =============================================================================================================
        Utils.readUsersV1(users);
        // Utils.readUsersV1(instructors); // Compile time error: incompatible types

        // With wildcards -- with no constraints on wildcards
        // =============================================================================================================
        Utils.readUsersV2(users);
        Utils.readUsersV2(instructors);

        // However, here we can pass GenericList of anything.
        Utils.readUsersV2(new GenericList<Integer>());
        Utils.readUsersV2(new GenericList<Object>());

        // With wildcards -- With extend constraint on wildcard
        // =============================================================================================================
        Utils.readUsersV3(instructors);
        Utils.readUsersV3(users);
        // Utils.readUsersV3(new GenericList<Integer>()); // Compile time error: incompatible types
        // Utils.readUsersV3(new GenericList<Object>()); // Compile time error: incompatible types

        // With wildcards -- With super constraint on wildcard
        // =============================================================================================================
        Utils.addUsers(users);
        // Utils.addUsers(instructors); // Compile time error: Required type: GenericList <? super User>
        // Utils.addUsers(new GenericList<Integer>()); // Compile time error: Required type: GenericList <? super User>
        Utils.addUsers(new GenericList<Object>());
    }
}
```

{% hint style="success" %}
We can have **multiple wildcards** in a method parameter declaration.
{% endhint %}

### Passing GenericList of any specific type

When a wildcard <kbd>?</kbd> is set as the type parameter of the `GenericList` class in a method parameter declaration as below, we can pass `GenericList` of any type to that method as arguments. We can pass even a `GenericList` of integers.

```java
// class CAP#1 {}
public static void printUsers(GenericList<?> users) {
    // Implementation ...
}
```



When we use a **wildcard**, the `Java Compiler` is going to create an **`anonymous type`** under the hood. This is going to be a regular class in Java. We won't see it, but it's there.

<figure><img src="../../.gitbook/assets/java-ad-generics-12-wildcards-1.png" alt=""><figcaption></figcaption></figure>

So the `get` method here, returns an instance of this capture class. i.e. If we get an object here, we can store it only in a variable of type capture (say CAP#1) or it's base type. That is `Object` class.

```java
//class CAP#1 {}
// users --> GenericList of any specific type
public static void printUsers(GenericList<?> users) {
    Object x = users.get(0);
    User y = (User) users.get(0); // Unsafe cast: no relationship between User and CAP#1(anonymous) class

    users.add(null);
    // users.add(new Object()); // Compile time error: required type: capture of ?
    // users.add(new User(1)); // Compile time error: required type: capture of ?
    // users.add(new Instructor(12)); // Compile time error: required type: capture of ?
}
```

Here, GenericList is a list of an unknown type.&#x20;

The wildcard `` `?` `` means "**some specific type, but we don't know which.**"&#x20;

Therefore, you cannot safely add any object (not even a \``User`\` or \``Instructor`\`) to it,  because the compiler **cannot guarantee type safety**.&#x20;

The only thing you can add to a GenericList is `null`.

## Add constraints on Wildcards

### Constraint with `extend` to pass all subtypes to the GenericList of anonymous type

```java
public class Utils {
    //class CAP#1 extends User {}
    //class Instructor extends User {}
    // users --> GenericList of any specific subtype of User class
    public static void printUsers(GenericList<? extends User> users) {
        User x = users.get(0);
        Instructor instructor = (Instructor) users.get(0); // Unsafe cast: no relationship between Instructor and CAP#1(anonymous) class
        
        users.add(null);
        // users.add(new User(1)); // Compile time error: required type: capture of ? extends User
        // users.add(new Instructor(12)); // Compile time error: required type: capture of ? extends User
    }
}

public class Main {
    public static void main(String[] args) {
        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();
        Utils.printUsers(users);
        Utils.printUsers(instructors);
        // Utils.readUsersV3(new GenericList<Integer>()); // Compile time error: incompatible types
        // Utils.readUsersV3(new GenericList<Object>()); // Compile time error: incompatibl
    
    }
}
```

When `Java Compiler` sees this implementation, it's going to have capture class (say CAP#1) extend the `User` class.

Now we cannot pass `GenericList` of integers when calling this method. It should be either `GenericList` of `User`s or one of it's subtypes.

<figure><img src="../../.gitbook/assets/java-ad-generics-12-wildcards-2.png" alt=""><figcaption></figcaption></figure>

Now we can retrieve an object from the `GenericList` and can assign it to a `User` variable since `User` class is the parent of this anonymous `CAP#1` type now.&#x20;

However we cannot assign the variable to a `Instructor` variable since `Instructor` and `CAP#1` are entirely 2 different classes like `Integer` and `String` classes. There's no connection between `Instructor` and `CAP#1` classes.

Also, with this implementation we cannot add `Instructor` or `User` objects to the `GenericList`. The compiler does not know the exact subtype of `User` the list holds, so adding a `User` or `Instructor` is unsafe.&#x20;

The only thing you can add to a GenericList is `null`.

<figure><img src="../../.gitbook/assets/java-ad-generics-12-wildcards-3.png" alt=""><figcaption></figcaption></figure>

<figure><img src="../../.gitbook/assets/java-ad-generics-12-wildcards-4.png" alt=""><figcaption></figcaption></figure>

### Constraint with `super` to add elements of all subtypes to the GenericList  of anonymous type&#x20;

If you want to add to a `GenericList`, you should use **`super`** keyword instead of **`extend`** keyword.

```java
public class Utils {
    //class User extends CAP#1 {}
    //class User extends Object {}
    //class Instructor extends User {}
    // users --> GenericList of User and/or any of its subtypes
    public static void printUsers(GenericList<? super User> users) {
        Object x = users.get(0);
        User y = (User) users.get(0); // Unsafe cast
        Instructor instructor = (Instructor) users.get(0); // Unsafe cast

        users.add(new User(1));
        users.add(new Instructor(12));

        // users.add(new Object()); // Compile time error: required type: capture of ? super User
    }
}

public class Main {
    public static void main(String[] args) {
        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();
        Utils.printUsers(users);
        // ?? cannot pass list of instructors to this method now
        // Utils.addUsers(new GenericList<Integer>()); // Compile time error: Required type: GenericList <? super User>
        Utils.addUsers(new GenericList<Object>());
    }
}
```

When Java Compiler sees this expression (`? super User`), it's gonna treat this unknown type as the parent of the `User` class.

So, the `users` list parameter above will be treated as if it was created as  the `users` list below;

```java
GenericList<ParentOfUserClass> users = new GenericList<>();
// i.e. 
GenericList<Object> users = new GenericList<>();
```

Now, to this you can add instance of the `User` class or any of it's subtypes.

```java
users.add(new User(1));
users.add(new Instructor(12));
```

Here, both `User` and `Instructor` types are directly or indirectly derived from the  `Object` class.&#x20;

However, you cannot add an `Object` because the list could be of type `User` or any of its subtypes, but not necessarily `Object`. Thus, only `User` and its subclasses are allowed.



If you use `super` keyword we cannot read `User`s from this list. &#x20;

╰┈➤ If you retrieve an object you'd have to store it in a variable of type `Object`  or you'll have to downcast. Downcasting may lead to `ClassCastException`.

```java
Object x = users.get(0);
```

