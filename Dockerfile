FROM openjdk:11-jre-slim

MAINTAINER Kirill Semenov <kirikx@mail.ru>

WORKDIR /app

COPY build/libs/skv-bot-0.0.1.jar ./app.jar

ENTRYPOINT java -jar ./app.jar

EXPOSE 8080
