
## Initial Setup

1. JDK 1.8.x,
Make sure that your java home is set to Java 1.8.
you can set it by editing .bashrc or .profile and paste this line.
```
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`
```
2. Download and install gradle. The version does not matter because the build setup uses Gradle Wrapper, 
which will pull down the version of gradle specified in the build setup. However, a version of gradle is 
necessary on your machine to initial run the build.

3. Install Gradle wrapper.
```
gradle wrapper --gradle-version 2.13
```

### Running the web application locally

```
$ ./gradlew bootRun
```

An in-memory database is used in this case. The configuration for the application is specified in **src/main/resources/application-default.properties**. 
This configuration uses a Spring Profile named **default**, which is configured in **build.gradle** as the default value for the **spring.profiles.active** property.

To build a war file to be deployed on Tomcat or other servlet container, execute the following:

```
$ ./gradlew war
```

The resulting war file will be stored in the **build/libs** directory.

To deploy with a different Spring Profile for a different deployment environment, specify the environment name on the command line...

e.g.

```
./gradlew bootRun -Dspring.profiles.active=dev
```
