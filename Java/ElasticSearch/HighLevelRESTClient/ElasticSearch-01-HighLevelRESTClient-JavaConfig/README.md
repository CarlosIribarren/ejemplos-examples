# Ejemplo

El objetivo de este ejemplo es un Hola Mundo del cliente de java de ElasticSearch. Simplemente conectar y ejecutar alguna consulta sencilla.

En este ejemplo se utiliza el cliente oficial de ElasticSearch para Java. 


```xml
		<dependency>
			<groupId>org.elasticsearch.client</groupId>
			<artifactId>elasticsearch-rest-high-level-client</artifactId>
			<version>7.6.2</version>
		</dependency>
```

Es una aplicacion de consola donde se conecta contra ElasticSearch y ejecuta busquedas de consulta sencillas.

## Indice
Se ejecuta contra un indice llamado "test"

El indice tiene los siguientes campos:
- spot: string
- device: string