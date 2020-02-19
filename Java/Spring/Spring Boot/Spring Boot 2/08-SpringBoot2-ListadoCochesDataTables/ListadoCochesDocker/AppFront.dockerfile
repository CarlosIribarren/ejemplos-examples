############################################################
## Etapa : Checkout ########################################
############################################################
FROM alpine/git AS ETAPA_GIT
WORKDIR /code/
RUN git clone https://github.com/CarlosIribarren/ListadoCochesSpringDataRestApi
RUN git clone https://github.com/CarlosIribarren/ListadoCochesDataTablesWEB

############################################################
## Etapa : Package #########################################
############################################################

# Se utiliza una imagen maven oficial entera para utilizar la carpeta m2
FROM maven:3.6.3-jdk-8 AS ETAPA_MAVEN

# ListadoCochesSpringDataRestApi
COPY  --from=ETAPA_GIT /code/ListadoCochesSpringDataRestApi/pom.xml /build/ListadoCochesSpringDataRestApi/
COPY  --from=ETAPA_GIT /code/ListadoCochesSpringDataRestApi/src /build/ListadoCochesSpringDataRestApi/src/
WORKDIR /build/ListadoCochesSpringDataRestApi/
RUN mvn -Dmaven.test.skip=true install

# ListadoCochesDataTablesWEB
COPY  --from=ETAPA_GIT /code/ListadoCochesDataTablesWEB/pom.xml /build/ListadoCochesDataTablesWEB/
COPY  --from=ETAPA_GIT /code/ListadoCochesDataTablesWEB/src /build/ListadoCochesDataTablesWEB/src/
WORKDIR /build/ListadoCochesDataTablesWEB/
RUN mvn -Dmaven.test.skip=true package 

############################################################
## Etapa : Ejecutar ########################################
############################################################

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=ETAPA_MAVEN /build/ListadoCochesDataTablesWEB/target/ListadoCochesDataTablesWEB.war /app/
ENTRYPOINT ["java", "-jar", "ListadoCochesDataTablesWEB.war"]

# Crear imagen
# ------------
#  docker image build --no-cache -t listado-coches-front .

# Crear container
# ---------------
#  docker run -p 8080:8080 listado-coches-front

# Probar
# ------
# http://localhost:8080/