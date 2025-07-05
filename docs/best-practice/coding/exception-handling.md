---
icon: circle-exclamation
---

# Exception Handling

## Exception Handling

✅ You should either prevent exceptions or should anticipate and handle exceptions.

✅️ Anticipate and handle edge cases.

✅️ It's best to log exceptions somewhere (e.g. file or database)&#x20;

✅️ If you are not printing an error message for the user to see when you catch an exception, then it's best  to re-throw them, so that somewhere else in the application a generic exception handler that catches all kinds of exceptions can get it and display a generic error message.&#x20;
