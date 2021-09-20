FROM adoptopenjdk:11-jdk-hotspot AS builder
WORKDIR /workdir/app
COPY ../spring-eureka-00-hello-service/.mvn   /workdir/app/.mvn
COPY ../spring-eureka-00-hello-service/mvnw /workdir/app/mvnw
COPY ../spring-eureka-00-hello-service/pom.xml /workdir/app/pom.xml

RUN ../spring-eureka-00-hello-service/./mvnw dependency:go-offline

COPY ../spring-eureka-00-hello-service/src /workdir/app/src
RUN ../spring-eureka-00-hello-service/./mvnw clean package

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /workdir/app/target/*.jar /app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]