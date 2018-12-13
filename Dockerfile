FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/corpdictionary-0.0.1-SNAPSHOT-standalone.jar /corpdictionary/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/corpdictionary/app.jar"]
