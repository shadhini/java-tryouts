---
description: Based on java.lang.Comparable<T> & java.util.Comparator<T> interfaces
icon: arrow-up-a-z
---

# Sorting Elements in a Collection

## Sorting Elements in a Collection

<table><thead><tr><th width="192.90625">Feature</th><th>Comparable Interface</th><th>Comparator Interface</th></tr></thead><tbody><tr><td></td><td><strong>single sorting sequence</strong> for objects of the implemented class via the <code>compareTo()</code> method</td><td>can create multiple <code>Comparator</code> implementations to <strong>define different sorting sequences</strong> externally</td></tr><tr><td></td><td><strong>intrusive to the class</strong>: class itself must implement Comparable; class need to be modified to change the sorting algorithm</td><td><strong>non-intrusive to the class</strong>: <code>Comparator</code>s are external; sorting algorithm can be modified without modifying the class itself</td></tr><tr><td>Define sorting</td><td>inside the class</td><td>outside the class</td></tr><tr><td>Number of sort orders</td><td>Only one</td><td>Multiple — as many as you want</td></tr><tr><td>Requires class change to change sort orders</td><td>Yes</td><td>No</td></tr><tr><td>Used for</td><td>Natural ordering</td><td>Custom ordering</td></tr></tbody></table>



{% content-ref url="comparable-interface-and-sorting.md" %}
[comparable-interface-and-sorting.md](comparable-interface-and-sorting.md)
{% endcontent-ref %}

{% content-ref url="comparator-interface-and-sorting.md" %}
[comparator-interface-and-sorting.md](comparator-interface-and-sorting.md)
{% endcontent-ref %}



