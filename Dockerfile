FROM openjdk:8
ADD target/madlibs-demo-0.0.1-SNAPSHOT.jar madlibs-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "madlibs-demo-0.0.1-SNAPSHOT.jar"]
