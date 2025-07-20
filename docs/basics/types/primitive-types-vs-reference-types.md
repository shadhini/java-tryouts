---
icon: not-equal
---

# Primitive Types vs Reference Types

<table><thead><tr><th align="center">Primitive Types</th><th align="center">Reference Types</th></tr></thead><tbody><tr><td align="center">For storing simple values.</td><td align="center">For storing complex objects.</td></tr><tr><td align="center">Don't have members.</td><td align="center">Classes &#x26; objects have <code>members</code> we can access using <code>dot</code> operator.</td></tr><tr><td align="center">Memory allocation &#x26; deallocation by JRE</td><td align="center">Memory deallocation by JRE.<br>But, memory allocation by developer with <code>new</code> operator.</td></tr><tr><td align="center"><strong>Store the actual value.</strong> <br>The value we assign to a variable will be stored in the memory location of the variable.</td><td align="center"><strong>Don't store the actual values, they store a reference to an object</strong>, somewhere in the memory.<br>The variable is going to hold the address of the   object created in the memory, not the actual object.</td></tr><tr><td align="center"><p><strong>Copied by value;</strong> these values are completely independent from each other.<br><br>If <code>x</code> has been assigned to <code>y</code>, changing value of <code>x</code>, does not change the value of <code>y</code>.</p><pre class="language-java"><code class="lang-java">byte x = 1;
byte y = x;
// x=1, y=1
x = 2;
// x=2, y=1
</code></pre></td><td align="center"><p><strong>Copied by references;</strong> thus values are not independent from each other.</p><p><br>If <code>point1</code> has been assigned to <code>point2</code>, changing value of <code>point1</code>, changes the value of <code>point2</code> as both variables points to the same memory address.</p><pre class="language-java"><code class="lang-java">Point point1 = new Point(1, 1);
Point point2 = point1;
// point1=[x=1,y=1], point2=[x=1,y=1]
point1.x = 3;
// point1=[x=3,y=1], point2=[x=3,y=1]
</code></pre></td></tr><tr><td align="center">Can use comparison operators between primitive variables.</td><td align="center">Cannot use comparison operators between reference types.</td></tr><tr><td align="center"></td><td align="center">Variables are initialised to <code>null</code> by default unless they have been initialised.</td></tr></tbody></table>

