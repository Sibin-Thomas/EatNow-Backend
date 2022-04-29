FROM openjdk:11

WORKDIR /app

COPY ./ ./

CMD ["java", "-jar", "./target/eatnow_backend-0.0.1-SNAPSHOT.jar"]
