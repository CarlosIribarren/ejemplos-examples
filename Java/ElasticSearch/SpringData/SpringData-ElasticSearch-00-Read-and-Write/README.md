# Ejemplo
En este ejemplo se muestra como utilizar Spring Data para leer/escribir,... contra ElasticSearch.

Para ello se ha añadido la siguiente dependecia de Spring:
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-elasticsearch</artifactId>
		</dependency>
```
Internamente utiliza la version 6.8.7 del cliente de ElasticSearch

# Probar ejemplo

## Obtener todos los documentos
Para obtener un documento realizar una peticion GET a la siguiente URL:
```
http://localhost:8081/elastic/api/channels/
```

## Crear un documento
Para crear un documento, realizar una peticion POST a la siguiente URL:
```
http://localhost:8081/elastic/api/channels/
```
con el siguiente JSON en el cuerpo de la peticion:
```json
{"id":"1","deviceId":"dispositivo 1","channelId":"canal 1","start":"2011/08/05 01:02:03","end":"2011/08/15 01:02:33"}
```


## Crear varios documentos
Para crear varios documentos en la misma peticion, realizar una peticion POST a la siguiente URL:
```
http://localhost:8081/api/channels/all
```
con el siguiente JSON en el cuerpo de la peticion:
```json
[
	{"id":"1","deviceId":"dispositivo 1","channelId":"canal 1","start":"2011/08/05 01:02:01","end":"2011/08/15 01:02:31"},
	{"id":"2","deviceId":"dispositivo 2","channelId":"canal 2","start":"2012/08/05 01:02:02","end":"2012/08/15 01:02:32"},
	{"id":"3","deviceId":"dispositivo 3","channelId":"canal 3","start":"2013/08/05 01:02:03","end":"2013/08/15 01:02:33"},
	{"id":"4","deviceId":"dispositivo 4","channelId":"canal 4","start":"2014/08/05 01:02:04","end":"2014/08/15 01:02:34"},
	{"id":"5","deviceId":"dispositivo 5","channelId":"canal 5","start":"2015/08/05 01:02:05","end":"2015/08/15 01:02:35"}
]
```
