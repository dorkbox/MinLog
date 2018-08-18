Drop-in replacement for [minlog](https://github.com/EsotericSoftware/minlog).

* Logs through slf4j instead of printing directly to stdout
* Suppresses no log levels at compile time so you can control them in your logging config instead


<h4>We now release to maven!</h4> 

```
<dependencies>
    ...
    <dependency>
      <groupId>com.dorkbox</groupId>
      <artifactId>MinLog-SLF4J</artifactId>
      <version>1.12</version>
    </dependency>
</dependencies>
```

  
Gradle Info
---------
````
dependencies {
    ...
    compile 'com.dorkbox:MinLog-SLF4J:1.12'
}
````

Or if you don't want to use Maven, you can access the files directly here:  
https://repo1.maven.org/maven2/com/dorkbox/MinLog-SLF4J/  


https://repo1.maven.org/maven2/org/slf4j/slf4j-api/


License
---------
This project is © 2008 Nathan Sweet (contributors Dan Brown and dorkbox llc), and is distributed under the terms of the BSD 3-clause License. See file "LICENSE" for further references.

