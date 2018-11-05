# externa

*An extension of the [Clojure Component library](https://github.com/stuartsierra/component) for system parts outside of the JVM*

[![][logo]][logo-large]

**A development work in progress ...**


## About

The component library allows for whole systems to be assembled and started from individual parts. The context for this
is the JVM in which the application is running. However, many complex software systems do not run inside the same process,
or not even on the same host. The externa project aims to close this gap and provide support for system components built
fronm the following:

* JAR files
* system processes
* docker containers
* all of the above on a remote host


## Initial Thoughts

* sending of serialized system state
* returning prcoess id/host + process id and updated (serialized) system state


## License

Apache License, Version 2.0.


<!-- Named page links below: /-->

[logo]: https://raw.githubusercontent.com/clojusc/externa/master/resources/images/logo-256.png
[logo-large]: https://raw.githubusercontent.com/clojusc/externa/master/resources/images/logo-800.png
