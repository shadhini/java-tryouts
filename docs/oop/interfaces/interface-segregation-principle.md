---
icon: plant-wilt
---

# Interface Segregation Principle

## Interface Segregation Principle

> **Segregate/ Divide big interfaces into smaller ones**
>
> ╰┈➤ Each interface should be focused on a single capability

* With this we can reduce the impact of changes



***

```java
public interface UIWidget {
    // We need these capabilities in a UIWidget
    void drag();
    void resize();
    void render();
}

public class Dragger {
    public void drag(UIWidget uiWidget) {
        uiWidget.drag();
        System.out.println("Dragging done!");
    }
}
```

Here,

* The `Dragger` class is dependent on `UIWidget` interface.
* However, `Dragger` class is only interested in dragging (`drag()` method). It has nothing to do with `resize()`, `render()` methods declared in the `UIWidget` interface.&#x20;
* But with this implementation even the changes to the signatures of resize(), render() methods `UIWidget` interface will affect the `Dragger` class.
  * i.e. If the signatures of `resize()`, `render()` methods change, then we will have to recompile and redeploy the `Dragger` class.

╰┈➤ Here, we have **`mixed different concerns or capabilities`** in the UIWidget interface.

***

```java
public interface UIWidget {
    void resize();
    void render();
}

public interface Draggable {
    void drag();
}

public class Dragger {

    public void drag(Draggable draggable) {
        draggable.drag();
        System.out.println("Dragging done!");
    }
}
```

Here,

* All we need in the `Dragger` class is a `Draggable` object.&#x20;
  * We don't care whether it is resizable or not; whether it can be rendered or not.
* The `Draggable` interface is very lightweight and we have only one coupling point.

***

Say we have objects/ui widgets which needs to have all capabilities; dragging, rendering and resizing.

╰┈➤ In this case we can use **`inheritance between interfaces`**.

```java
public interface Draggable {
    void drag();
}

public interface Resizable {
    void resize(int size);
    void resize(int width, int height);
    void resize(UIWidget uiWidget);
}

public interface UIWidget extends Draggable, Resizable {
    void render();
}
```

Now `UIWidget` interface will inherit the `drag()` method from `Draggable` interface and `resize()` methods from the `Resizable` interface.

