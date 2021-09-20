# Swagger centralziado con Zuul configurado con ficheros de propiedades
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


## Puerto y host de Zull
Hay que configurar donde se encuentra Zuul (host) y en que puerto, para que cuando se pruebe un metodo, la llamada se realize contra Zuul
```yml
springfox:
  documentation:
    swagger:
      v2:
        host:  localhost:8090
```
El valor del HOST (localhost) y el puerto de Zuul (8090) se pueden pasar por parametro.

## Resultado
De tal modo que cuando se ejecuta una llamada desde swagger-ui, se realiza la llamada a la aiguiente URL:
```
http://localhost:8090/api/energy-communities/energy-communities/
```
