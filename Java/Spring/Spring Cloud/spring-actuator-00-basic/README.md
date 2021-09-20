# Spring Actuator

## Configurar
Añadir la siguiente dependecia en el POM:

```xml
<dependency>
    <groupID>org.springframework.boot</groupID>
    <artifactID>spring-boot-starter-actuator</artifactID>
</dependency>
```

## Activar o desactivar metodos

Los metodos actuators se pueden utilizar con dos tipos de conexiones: WEB y JMX. 

Para la conexion JMX casi todos los metodos estan activados. 

Mientras para la conexion WEB solo estan habilitados dos:

- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/info

Se pueden activar o desactivar, es decir, exponer o no exponer, utilizando las siguientes propiedades en el fichero appilaction.properties. 

A continuacion se muestran 4 propiedades, en JMX dos y WEB otras dos: unas para incluir y otras para excluir. 

Se puede utilizar el nombre del actuator o se puede generalizar con un asterisco:
```
management.endpoints.jmx.exposure.exclude
management.endpoints.jmx.exposure.include = *
management.endpoints.web.exposure.exclude
management.endpoints.web.exposure.include = info, health
```

Un ejemplo seria el siguiente:

Para activar todos los actuators para la WEb, podemos añadir esta propiedad en el appilaction.properties:
```
management.endpoints.web.exposure.include = *
```


## Health
Nos permite verificar si la aplicación se encuentra levantada o no.

Si se quiere tener mas detalle en este metodo añadir la siguiente propiedad en el appilaction.properties:
```
management.endpoint.health.show-details=always
```

Si se llama a la URL "http://localhost:8080/actuator/health" se obtendra el siguiente JSON:
```json
{
	"status": "UP",
	"components": {
		"diskSpace": {
			"status": "UP",
			"details": {
				"total": 255400603648,
				"free": 118615547904,
				"threshold": 10485760,
				"exists": true
			}
		},
		"ping": {
			"status": "UP"
		}
	}
}
```

## Info
Nos permite obtener informacion de la aplicación.

### Informacion estatica
Una manera estatica de definir la informacion seria definiendo las siguientes propiedades en el appilaction.properties:
```
info.app.info=sample of a static information
```

### Informacion dinamica
Una manera de mostrar informacion dinamica seria definiendo las siguientes propiedades en el appilaction.properties:
```
info.app.name = @project.name@
info.app.groupId = @project.groupId@
info.app.artifactId = @project.artifactId@
info.app.version = @project.version@
```

Si se llama a la URL "http://localhost:8080/actuator/info" se obtendra el siguiente JSON:
```json
{
	"app": {
		"description": "This is my first spring boot application",
		"name": "spring-actuator-00-hello-service",
		"groupId": "oiasso.systems.spring.actuator",
		"artifactId": "spring-actuator-00-hello-service",
		"version": "0.0.1-SNAPSHOT"
	}
}
```




