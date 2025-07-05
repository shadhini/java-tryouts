---
icon: sd-cards
---

# OS Resources

## OS Resources

Resources like file handles, database connections, network connections.. are operating system resources.&#x20;

✅️  Whenever we acquire, occupy  external resources, we should always release them.&#x20;

* Otherwise other processes may not be able to access these resources.&#x20;

✅️  If the classes we use to acquire, occupy external resources implements `AutoCloseable` interface, then use try with resources statement.
