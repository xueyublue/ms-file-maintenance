# Start with a base image containing Java runtime
FROM openjdk:17-slim as build

# Information around who maintains the image
MAINTAINER darren

# Add the application's jar to the container
COPY target/ms-file-maintenance-1.0.0.jar ms-file-maintenance-1.0.0.jar

# execute the application
ENTRYPOINT ["java", "-jar", "/ms-file-maintenance-1.0.0.jar"]