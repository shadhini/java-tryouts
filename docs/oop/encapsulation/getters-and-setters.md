---
icon: function
---

# Getters and Setters

> **`private fields`**/data members
>
> **`public setter methods`** with field `data validation` logic to set values for these fields&#x20;
>
> **`public getters`**; if it is necessary to access the data field values&#x20;

If we are taking values from the user, we need to do some data validations before setting it as an object's filed value.

We need to encapsulate these data validation logics also inside the class.&#x20;

* Then, whenever we use this class, we're going to have this data validation logic.&#x20;
* Thus, we don't have to repeat data validation logic everywhere.

Therefore, we can't make these fields directly accessible to the user directly.

* Instead we need to make data members inaccessible from outside the class and declare a method with data validation to set values of data members.
* This method should be accessible/ callable from outside.



➡️ **Setter method with data validations** prevents an object from going into an `invalid state`.

➡️ If you need `read only field` -> only add a getter



{% hint style="warning" %}
ℹ️ In complex applications, we are not going to declare getters and setters for every field. One method declared might change few fields.
{% endhint %}



