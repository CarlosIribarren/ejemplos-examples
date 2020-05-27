# Ejemplo
En este ejemplo se muestra como cargar muchos datos utilizando Spring Data contra ElasticSearch.

Para ello se ha añadido la siguiente dependecia de Spring:
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-elasticsearch</artifactId>
		</dependency>
```
Internamente utiliza la version 6.8.7 del cliente de ElasticSearch

# Probar ejemplo

## Cargar datos
Para cargar los datos realizar una peticion GET a la siguiente URL:
```
http://localhost:8081/elastic/api/channels/cargar-datos
```

