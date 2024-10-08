FROM openjdk:21-jdk-buster
MAINTAINER YoungChen
WORKDIR app
ADD build/libs/*.jar app.jar
EXPOSE 6666
ENTRYPOINT ["java","-jar","app.jar"]