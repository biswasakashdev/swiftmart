FROM maven:3.9.12-eclipse-temurin-21-alpine AS builder

WORKDIR /app

COPY services/users .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine-3.23

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 50001

ENTRYPOINT [ "java", "-jar","app.jar"]
