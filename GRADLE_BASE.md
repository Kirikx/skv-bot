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


### Guides


### Additional Links

