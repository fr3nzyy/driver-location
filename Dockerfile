FROM adoptopenjdk/openjdk11
COPY target/driver-location*.jar driver-location.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/driver-location.jar"]