# Pro way of writing Dockerfile
FROM maven:3-openjdk-17 as build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
RUN mkdir /project
COPY --from=build /app/target/informix-0.0.1.jar /project
WORKDIR /project
ENTRYPOINT ["java","-jar","url_shortener-0.0.1.jar"]