Drop-in replacement for [minlog](https://github.com/EsotericSoftware/minlog).

###### [![Dorkbox](https://badge.dorkbox.com/dorkbox.svg "Dorkbox")](https://git.dorkbox.com/dorkbox/MinLog) [![Github](https://badge.dorkbox.com/github.svg "Github")](https://github.com/dorkbox/MinLog) [![Gitlab](https://badge.dorkbox.com/gitlab.svg "Gitlab")](https://gitlab.com/dorkbox/MinLog)

* Logs through slf4j instead of printing directly to stdout
* Suppresses no log levels at compile time so you can control them in your logging config instead


Maven Info
---------
```
<dependencies>
    ...
    <dependency>
      <groupId>com.dorkbox</groupId>
      <artifactId>MinLog</artifactId>
      <version>2.5</version>
    </dependency>
</dependencies>
```

Gradle Info
---------
```
dependencies {
    ...
    implementation("com.dorkbox:MinLog:2.5")
}
```

License
---------
This project is © 2008 Nathan Sweet (contributors Dan Brown and dorkbox llc), and is distributed under the terms of the BSD 3-clause License. See file "LICENSE" for further references.

