---
icon: circle-exclamation
---

# Concurrency Issues

## Concurrency Issues

In a real scenario, sometimes different threads may need to access and modify shared resources.



* E.g: When downloading files, each thread may report the number of bytes it has downloaded to a shared object; `totalBytes`. But with this object, we can keep track of the entire download progress and report it to the user.
  * Now multiple threads access the same object
  * And at least one of them changes the object
  * ╰┈➤ <kbd>So we are going to run into a couple of issues</kbd>



If multiple threads access the same data, and al least one of them tries to change it,&#x20;

&#x20;        ╰┈➤ we are gonna have some problems

If they only want to read the shared data, then that' s perfectly fine.

### Issue 1: Race Conditions

> **Race Conditions**:
>
> — multiple threads are racing or competing to modify shared data —&#x20;
>
> Happens when multiple threads try to modify the same data at the same time.



* we can get wrong results or application may crash

{% content-ref url="race-conditions.md" %}
[race-conditions.md](race-conditions.md)
{% endcontent-ref %}



### Issue 2: Visibility Problem

> **Visibility Problem**:
>
> — different threads have different views of the shared data —&#x20;
>
> Happens when one thread changes the shared data, but its changes are not visible to other threads.









