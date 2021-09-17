FROM openjdk:11
VOLUME /tmp
EXPOSE 8181
ADD ./target/ms-candidate-0.0.1-SNAPSHOT.jar ms-candidate.jar
ENTRYPOINT [ "java", "-jar", "/ms-candidate.jar"]