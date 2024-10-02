---
description: Deploying Command Line Applications
icon: box-open-full
---

# Packaging Java Applications

Now, you've developed a Java program and you want to give it to someone else to use.

╰┈➤ Then you need to package your code into a `jar` file.

**`JAR`**`:`` `**`J`**`ava`` `**`AR`**`chive` ; a package file format that contains all the code for distribution.



Anyone who have installed Java Runtime Environment (`JRE`), can execute a `jar` file.



**`Artifact`**: an assembly/ combination of all the project assets that we put together.



## Using IntelliJIDEA IDE

{% content-ref url="https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/intellijidea/packaging-java-applications" %}
[Packaging Java Applications](https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/intellijidea/packaging-java-applications)
{% endcontent-ref %}





## To invoke JVM (Java Virtual Machine) and run the program

1. Go to the directory where .jar file resides in terminal
2. `java -jar <ARTIFACT_NAME>.jar`

Mac/Linux are `case sensitive`. Thus, be aware of necessary capitalisation of `jar` name.

