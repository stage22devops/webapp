FROM openjdk:8

EXPOSE 9001

ADD target/webapp-0.0.1-SNAPSHOT.jar webapp-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/webapp-0.0.1-SNAPSHOT.jar"]
