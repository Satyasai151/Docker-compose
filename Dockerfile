FROM openjdk:8
EXPOSE 8080

COPY target/productapp-0.0.1-SNAPSHOT.jar productapp-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java", "-jar", "/productapp-0.0.1-SNAPSHOT.jar"]
