# Book Inventory

## Functionality
* Reader(consumer) requests to read a book
* Book provider(producer) finds that book(generates) and lets the reader read it. 

reader module functions
* requesting a book
* viewing book details

provider module functions
* generating a book
* updating a book

## Procedure

1. Create a maven project from IntelliJ IDEA with following details

        groupId: com.shadhini.java.tryouts.osgi.book
        artifactId: book-inventory
        version: 1.0-SNAPSHOT
        packaging: pom
        name: Book Inventory

    * We give packaging as `pom` and here, we are **not exporting the parent** module.
    * You can delete the auto generated `src` folder at the parent module directory

   
2. Create two submodules

         com.shadhini.java.tryouts.osgi.book.reader 
         com.shadhini.java.tryouts.osgi.book.provider 

    * To create these modules, 
      * right-click on the parent project and select `Add New` → `Module` 

    * When adding sub-modules to the project, 
      * the **parent project pom.xml** should be updated with `<modules>` and 
      * the **sub-modules pom.xml** will have `<parent>` tags. 
      * If you are using an IDE, it auto generates them.


3. Book Provider POM

   ```
   artifactId: com.shadhini.java.tryouts.osgi.book.provider
   packaging: bundle
   plugin: maven-bundle-plugin, maven-scr-plugin
   dependency: org.apache.felix.scr.ds-annotations, org.eclipse.osgi.services, org.eclipse.osgi
   name: Book Provider
   ```

    * `<packaging>bundle</packaging>` is used since we need this to be bundled in 
    * In `maven-bundle-plugin` we identify 
      * Bundle-Symbolic-Name 
      * Bundle-Name 
      * Export-Package 
      * Import-Package 
      * Private-Package


4. Add implementation to `book provider` module
    * Book.java
    * Book Provider.java
    * BookProviderImpl.java


5. Register the created service of the `book provider` in a registry to use it from other components

    * BookProviderServiceComponent.java -- similar to an Activator 


6. Book Reader POM

```
artifactId: com.shadhini.java.tryouts.osgi.book.reader
packaging: bundle
plugin: maven-bundle-plugin, maven-src-plugin
dependency: org.apache.felix.src.ds-annotations, org.eclipse.osgi.services, org.eclipse.osgi, com.shadhini.java.tryouts.osgi.book.provider
name: Book Reader

```


7. Add implementation to `book reader` module
   * Reader.java
   * ReaderDataHolder.java


8. Access `book provider` service from book reader
   * ReaderComponent.java


9. Build project

```bash
 JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home mvn clean install -DskipTests
```
   * This will generate folder named `target`  in 
      * com.shadhini.java.tryouts.osgi.book.reader and 
      * com.shadhini.java.tryouts.osgi.book.provider 
   * Inside those folders there are `JARs` 
      * com.shadhini.java.tryouts.osgi.book.reader-1.0-SNAPSHOT.jar and 
      * com.shadhini.java.tryouts.osgi.book.provider-1.0-SNAPSHOT.jar 
   * When you unzip them you can see  
      * the code and 
      * the `MANIFEST.MF` files and 
      * `OSGI-INF` files

   
