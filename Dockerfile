FROM openjdk:8
VOLUME /tmp
EXPOSE 9001
ADD ./target/microservice_authorization_server-0.0.1-SNAPSHOT.jar microservice_authorization_server.jar
ENTRYPOINT ["java","-jar","microservice_authorization_server.jar"] 