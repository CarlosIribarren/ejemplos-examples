FROM adoptopenjdk:11-jdk-hotspot AS builder
WORKDIR /workdir/app
COPY ../spring-eureka-00-eureka-service/.mvn   /workdir/app/.mvn
COPY ../spring-eureka-00-eureka-service/mvnw /workdir/app/mvnw
COPY ../spring-eureka-00-eureka-service/pom.xml /workdir/app/pom.xml

RUN ../spring-eureka-00-eureka-service/./mvnw dependency:go-offline

COPY ../spring-eureka-00-eureka-service/src /workdir/app/src
RUN ../spring-eureka-00-eureka-service/./mvnw clean package

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /workdir/app/target/*.jar /app.jar
EXPOSE 8761

CMD ["java", "-jar", "/app.jar"]