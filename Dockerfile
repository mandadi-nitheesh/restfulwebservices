FROM openjdk:17
LABEL maintainer="nitheesh"
ADD target/RestfulWbservice-0.0.1-SNAPSHOT.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","spring-boot-docker.jar"]