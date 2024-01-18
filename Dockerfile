FROM maven:3.9.6-amazoncorretto-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:17-ea-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]