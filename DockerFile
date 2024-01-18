FROM maven:3.9.6-amazoncorretto-17 as build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

WORKDIR /app
COPY . .

RUN apt-get install maven -y
RUN mvn clean package -X -DskipTests

FROM openjdk:17-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]