FROM registry.docker.yixinonline.org/java:oracle-8u101-jdk-alpine

VOLUME /tmp

ADD meifans-helloWorld-0.0.1-SNAPSHOT.jar /meifans-helloWorld.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/meifans-helloWorld.jar"]