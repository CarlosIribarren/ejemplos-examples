# Swagger centralziado con Zuul modificado el proyecto de documentation
En este ejemplo se muestra como utilizar Zuul y swagger centralizado. 

Para ello se tiene que configurar dos cosas:

## BasePath de Swagger
Hay que configurar el BasePath de swagger para que cuando estemos en la pagina swagger-ui probando los metodos, añada el BasePath al ejecutar las llamadas.

Esto es necesario ya que en Zuul hemos configurado que para un path concreto responde un microservicio concreto. 

Y de esta manera estamos añadiendo la parte de la URL para que Zuul pueda redirigirlo correctamente.
```java
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			    .pathProvider(new RelativePathProvider(servletContext) {
			        @Override
			        public String getApplicationBasePath() {
			            return "/api/energy-communities";
			        }
			    })
				.apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(Predicates.not(PathSelectors.regex("/error.*")))
	            .build();
	}
```

Es decir, en Zuul esta configurado de la siguente manera:
```yml
zuul: 
  routes: 
    energycommunities:
      path: /api/energy-communities/**
      service-id: edinor-energy-communities-service
```


## Documentation modificado
Se ha modificado el proyecto de documentation, para que sustituya el puerto de Zuul en la configuracion de los microservicios.


Se guarda el puerto de Zuul y continua con la siguiente iteracion.
```java
				final Integer microServicePort = instance.getPort();
				
				// Save zuul port
				if(serviceId.contains("zuul")) {
					zuulPort = microServicePort;
					return;
				}
```
Posteriormente se sustituye en el JSON con el que se configura Swagger
```java
					// Replace zuulPort in microServicePort
					if(microServicePort != null && zuulPort != null) {
						content = content.replace(microServicePort.toString(), zuulPort.toString());
					}
```
De esta manera ya no hay que configurar la propiedad con el puerto de Zuul en el properties/yml
```yml
springfox:
  documentation:
    swagger:
      v2:
        host:  localhost:8090
```


## Hostname
Es necesario configurar el hostname en cada microservicio, para que en la configuracion de swagger se cargue esta propiedad correctamente, y al probar los metodos en el ui, se realize la llamda al host que corresponde:
```yml
eureka:
  instance:
    appname: edinor-installation-studies-service
    instance-id: ${spring.application.name}:${server.port}
    hostname: localhost
```




## Resultado
De tal modo que cuando se ejecuta una llamada desde swagger-ui, se realiza la llamada a la aiguiente URL:
```
http://localhost:8090/api/energy-communities/energy-communities/
```
