FROM adoptopenjdk/maven-openjdk12 AS MAVEN_BUILD

WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/
RUN mvn clean package 

FROM openjdk:12
COPY --from=MAVEN_BUILD /build/target/*.jar /service.jar

ENTRYPOINT ["java","-jar","/service.jar"]
