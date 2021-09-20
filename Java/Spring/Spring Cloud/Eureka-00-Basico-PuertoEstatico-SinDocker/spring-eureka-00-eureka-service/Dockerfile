FROM adoptopenjdk:11-jdk-hotspot AS builder
WORKDIR /workdir/app
COPY .mvn   /workdir/app/.mvn
COPY mvnw /workdir/app/mvnw
COPY pom.xml /workdir/app/pom.xml

RUN ./mvnw dependency:go-offline

COPY src /workdir/app/src
RUN ./mvnw clean package

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /workdir/app/target/*.jar /app.jar
EXPOSE 8761

CMD ["java", "-jar", "/app.jar"]