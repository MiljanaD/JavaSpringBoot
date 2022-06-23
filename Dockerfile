FROM openjdk:18
ADD target/demo-0.0.1.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/demo.jar"]
