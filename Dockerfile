FROM maven:3.8.5-openjdk-17-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/todolist-0.0.1-SNAPSHOT.jar /app/todolist-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "todolist-0.0.1-SNAPSHOT.jar"]
