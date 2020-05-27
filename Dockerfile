#FROM maven:3.5.2-jdk-8-alpine as MAVEN_ENV
#WORKDIR /build/
#COPY . /build/
#RUN mvn clean package -DskipTests=true

FROM openjdk:8-jre-alpine
WORKDIR /app/
COPY  /target/space-management-system-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
