# Getting Started

1. Включение зависимостей. 

Разница в импорте зависимостей compile <--> implementation
Согласно документации на gradle:

Вы всегда должны использовать **implementation**, а не **compile** для зависимостей, поскольку компиляция теперь устарела или удалена в случае Gradle 7+.
[link](https://tomgregory.com/gradle-implementation-vs-compile-dependencies/)

В Gradle вы можете проверять свои пути к классам с помощью этой задачи:
```bash
./gradlew dependencies --configuration <compileClasspath | runtimeClasspath>
```
подставляя нужную конфигурацию

### Reference Documentation

https://stackoverflow.com/questions/44493378/whats-the-difference-between-implementation-api-and-compile-in-gradle
https://tomgregory.com/gradle-implementation-vs-compile-dependencies/
https://docs.gradle.org/current/userguide/platforms.html

https://coderoad.ru/57717042/%D0%9D%D1%83%D0%B6%D0%B5%D0%BD-%D0%BB%D0%B8-%D0%BD%D0%B0%D0%BC-%D0%BF%D0%BB%D0%B0%D0%B3%D0%B8%D0%BD-io-spring-dependency-management-gradle-%D0%BA%D0%BE%D0%B3%D0%B4%D0%B0-%D0%BC%D1%8B-%D1%83%D0%B6%D0%B5
https://scans.gradle.com/?_ga=2.10601588.1329919022.1633867751-1317364797.1622731207#gradle
https://docs.gradle.org/current/userguide/viewing_debugging_dependencies.html

https://www.baeldung.com/spring-boot-thin-jar
https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/

https://github.com/reactor/reactor-core/pulls/OlegDokuka
https://github.com/spring-gradle-plugins/dependency-management-plugin
https://github.com/reactor/reactor
https://github.com/spring-gradle-plugins/dependency-management-plugin
### Guides


### Additional Links

