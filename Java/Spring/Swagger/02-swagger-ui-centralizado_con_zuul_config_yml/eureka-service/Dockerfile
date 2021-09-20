FROM adoptopenjdk/maven-openjdk12 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean package -B -DskipTests

FROM adoptopenjdk/maven-openjdk12 AS MAVEN_TEST

COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
#RUN mvn test -B

FROM adoptopenjdk/maven-openjdk12 AS MAVEN_QG

ARG SONAR_HOST=HOST
ARG SONAR_TOKEN=TOKEN

COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
#RUN mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install
#RUN mvn org.jacoco:jacoco-maven-plugin:prepare-agent clean install -P coverage-per-test
RUN mvn sonar:sonar -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN}

FROM openjdk:12

ARG ARTIFACT_NAME=ONE-SERVER

COPY --from=MAVEN_BUILD /build/target/${ARTIFACT_NAME}-*.jar /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/${ARTIFACT_NAME}.jar"]
HEALTHCHECK --interval=30s --timeout=3s --retries=3 CMD curl --fail http://localhost:8761/actuator/health || exit 1
