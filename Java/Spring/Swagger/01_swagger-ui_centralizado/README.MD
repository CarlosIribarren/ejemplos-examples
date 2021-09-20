# Swagger UI Centralizado
En este ejemplo se muestra como tener un solo swagger-ui con varios microservicios.
Para ello es necesaria la ayuda de Spring-Eureka

# Configuracion de los microservicios

# Hostname
A la hora de probar las APIS, para que las llamadas se realizen contra el hostname correcto, es necesario definir un hostname:

```yml
eureka:
  instance:
    appname: employee-application
    instance-id: ${spring.application.name}:${server.port}
    hostname: localhost
```

## CORS
A la hora de probar las APIS, para que cuando desde el swagger-ui central se hagan llamadas al los microservicios, es necesario que los microservicios tengas el CORS quitado: (si no da error de CORS)
```java
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
```

