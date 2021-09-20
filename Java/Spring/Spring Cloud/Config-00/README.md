# Spring Cloud Config Ejemplo 

Este ejemplo consta de dos proyectos:
- spring-config-00-config-service : Se encarga de descargar las configuraciones de GitHub y exponerlas en una API para que los otros proyectos las utilicen.
- spring-config-00-hello-service : Servicio normal que consume la configuracion del proyecto de config-service.



# spring-config-00-config-service

## Configuracion

Se añade la anotacion de @EnableConfigServer
```java
@EnableConfigServer
@SpringBootApplication
public class SpringConfig00ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfig00ConfigServerApplication.class, args);
	}

}
```

Se define la URL del repositorio donde se encuentran las propiedades:

```
spring.application.name=config-server
server.port=8888

spring.cloud.config.server.git.uri=https://github.com/CarlosIribarren/spring-config-files
```

NOTA: Este repositorio no esta securizado. En produccion la manera de protejerlo sera con docker, ya que que no estara expuesto hacia fuera.


## Probar que el servicio de Spring Config funciona

Se pueden hacer llamadas GET a las siguientes URL:

```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```


# spring-config-00-hell-service


## Configuracion
Se define un fichero bootstrap.properties, en donde se define de donde obtendra las configuraciones extra.
Tambien se define el perfil de las configuraciones.
```
spring.profiles.active=local
spring.cloud.config.uri=http://localhost:8888
```

Al ir a buscar el fichero de configuracion, tendra en cuenta el perfil (profile). El nombre de los ficheros tiene que concidir con el nombre del perfil. Si no se indica o no encuentra el perfil (profile), cargara el de pordefecto, es decir, solo el nombre del proyecto.
```
/{application}-{profile}.properties
```

En el application.properties se definen la configuracion general:
```
spring.application.name=hello-service
server.port=8080
```

Como el nombre del servicio esta definido con el nombre de "hello-service" al ir a buscar el fichero de configuracion, buscara un fichero con el nombre de hello-service, y como en el bootstrap.properties esta puesto el perfil (profile) de local, buscara el siguiente fichero dentro del repositorio de ficheros de configuracion:
```
hello-service-local.properties
```


# Probar ejemplo

Al entrar en la URL, se tiene que visualizar el mensaje del perfil que se ha configurado.
```
http://localhost:8080/
```

NOTA: Existen dos ficheros de configuracion en el repositorio (hello-service.properties y hello-service-local.properties), cada uno con un mensaje, para verificar que se obtiene la propiedad correcta con el perfil (profile) concreto.


