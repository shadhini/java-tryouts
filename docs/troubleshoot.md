---
icon: screwdriver-wrench
---

# Troubleshoot

## source release X requires target release X

{% hint style="danger" %}
java: warning: source release 11 requires target release 11
{% endhint %}

**If you use Maven:**\
`pom.xml`&#x20;

```xml
<properties>
   <maven.compiler.source>11</maven.compiler.source>
   <maven.compiler.target>11</maven.compiler.target>
</properties>
```

**If you use Gradle:**\
`build.gradle`

```groovy
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
```

**Via IntelliJIDEA:**

1. Set Project SDK and Language Level
   * **File** > **Project Structure** > **Project**,
     * **Project SDK** -- Java 11
     * **Project language level** -- “11 - Local variable syntax for lambda parameters”
2. Set Compiler Settings
   * **Project Structure** > **Modules**,
     * Select module & then ensure the **Module SDK** and **Language level** are set to 11.

