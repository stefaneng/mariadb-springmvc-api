# Spring MVC JSON Api with MariaDB
This is an example application with tutorial on setting up a Spring MVC JSON Api with persistent data storage to MariaDb.

## Step 1
Create a new maven project.
Using eclipse go to `File > New > Maven Project`.
Run the example maven project using [run.sh](./run.sh) or
```
mvn -q exec:java -Dexec.mainClass="com.stefanengineering.examples.spring_mariadb.App"
```
Which should print
```
Hello World!
```

## Step 2
Now we are going to setup spring boot, which is a quick way to run spring applications without worrying about configuration using xml.
We are going to manage each dependency ourselves to ensure we know what is going on.
First let's set the spring version we are going to use in [pom.xml](./pom.xml)
```{xml}
  <properties>
    ...
    <springboot.version>1.4.3.RELEASE</springboot.version>
  </properties>
```
Then we want to add the dependency for spring-boot and spring-boot-autoconfigure to simplify configuration by adding
```{xml}
<dependencies>
  ...
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot</artifactId>
    <version>${springboot.version}</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
    <version>${springboot.version}</version>
  </dependency>
</dependencies>
```
We will also add the maven spring boot plugin to add the maven goal `spring-boot:run`. This will run our application.
```{xml}
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <version>${springboot.version}</version>
    </plugin>
  </plugins>
</build>
```
Next we need to make our application use spring-boot. Update [App.js](./src/main/java/com/stefanengineering/examples/spring_mariadb/App.java) with the following code:
```{java}
package com.stefanengineering.examples.spring_mariadb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```
Just as a note from the [Spring Documentation](http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-using-springbootapplication-annotation.html)
> The `@SpringBootApplication` annotation is equivalent to using `@Configuration`, `@EnableAutoConfiguration` and `@ComponentScan` with their default attributes

Now we can run our application with `mvn spring-boot:run`
```
$ mvn -q spring-boot:run

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.3.RELEASE)
...
INFO: Started App in 0.316 seconds (JVM running for 1.927)
```

