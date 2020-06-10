# Descripcion del ejemplo
En este ejemplo se muestra como securizar una API REST utilizando solo JWT. 

Este ejemplo no sigue el estandar de OAuth2.

![](ejemplo.png)

En este ejemplo la parte de Autenticacion y Autorizacion estan en el mismo proyecto, por lo que estan en el mismo servidor. Lo mas normal seria que la parte de Autenticacion este en otro proyecto y asi poder estar en otro servidor, para que pueda servir para mas aplicaciones, estando asi la Autenticacion centralizada.

Este Ejemplo no utiliza la libreria de spring-security-jwt. Solo se utilizan las librerias de Spring Security y jwt.

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>		

<dependency>
        <groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
</dependency>	
```

En este ejemplo seria la aplicacion cliente responsable de guardar en Token para cada usuario. (Por seguridad no podrian ser ni SPA ni aplicaciones moviles, ya que se podria obtener facilmente el token.)

En este ejemplo el Token tiene un tiempo de expiracion de 5 min. Si cuando se parsea el Token, la validez del token se ha expirado, produce una excepcion de tipo ExpiredJwtException.

El Token esta encriptado con la codificacion HS512.

# Probar el ejemplo

## Hacer login en la API REST: 

Hacer una peticion para logearse:

        Peticion: POST 
        URL: http://localhost:8080/api/login 
        Cuerpo ( Datos en JSON ): { "username": "admin", "password": "admin"}

Retorna una respuesta 200 OK. En la cabecera esta el TOKEN de JWT, en el atributo "Authorization"

        Bearer  eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE1ODI2NDEz8iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTU4MzUwNTM1N30.whQzgJUh1-POA8ALsDiX8rvWjrl0Xb7ZiL-wrmdnFr0MRUq6kGmQUAsl4pOCzsq7hrfn-GVx8kZOBvbRF2uolw


## Utilizar la API REST con el TOKEN de JWT: 

Hacer una peticion a una URL de la API REST enviando el TOKEN de JWT recibido en la peticion de login.
Para ello crear en la cabecera un atributo de nombre "Authorization" y con el valor del TOKEN recibido.

        Peticion: GET 
        URL: http://localhost:8080/api/nota/all
        Cabecera: Authorization : Bearer  eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE1ODI2NDEz8iLCJzdWIiOiJhZG1pbiIsImV4cCI6MTU4MzUwNTM1N30.whQzgJUh1-POA8ALsDiX8rvWjrl0Xb7ZiL-wrmdnFr0MRUq6kGmQUAsl4pOCzsq7hrfn-GVx8kZOBvbRF2uolw 


# Configuracion 
Se desactiva el uso de cookies.

Podemos observar que se ajusta la configuración para CORS y se desactiva el filtro de Cross-site request forgery (CSRF). Esto nos permite habilitar el API para cualquier dominio, esta es una de las grandes ventajas del uso de JWT.

Se indica que el login no requiere autenticación.

Se indica que el resto de URLs esten securizadas.

```java
http
	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	.cors().and()
	.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()));
```

## Autenticacion
Creamos un filtro JWTAuthenticationFilter que extiende del filtro UsernamePasswordAuthenticationFilter. El filtro UsernamePasswordAuthenticationFilter responde a cualquier peticion en la URL /login

```java
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
```

En la configuracion, al crear el JWTAuthenticationFilter, se le pasa en el constructor la implementacion por defecto de AuthenticationManager de Spring Security. 

```java
.addFilter(new JWTAuthenticationFilter(this.authenticationManager()))
```

Al procesar una peticion POST en la URL de /login. Se obtienen los datos de usuario y password enviados en el POST como JSON, y se llama al metodo authenticate(usernamePasswordAuthenticationToken) de la clase AuthenticationManager. Este metodo utiliza la implementacion de UserDetailsService para validar el usuario contra la BD.

```java
Usuario credenciales = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>());
return this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
```


## Autorizacion
Creamos un filtro JWTAuthorizationFilter que extiende del filtro BasicAuthenticationFilter. El filtro BasicAuthenticationFilter responde a cualquier peticion contra la API. Excepto la URL de /login

```java
public class JWTAuthorizationFilter extends BasicAuthenticationFilter
```

Se verifica que en el encabezado de la peticion se encuentre un atributo con nombre "Authorization" y en su valor que empieze por "Bearer ..." (Esas dos cadenas se definen en el codigo)

```java
String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
	chain.doFilter(req, res);
	return;
}
```

Se procesa el token y se recupera el usuario

```java
String user = Jwts.parser()
				.setSigningKey(SUPER_SECRET_KEY)
				.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""))
				.getBody()
				.getSubject();
```

Se registra el usuario en el contexto de seguridad de Spring Security en cada peticion, ya que no se guarda informacion en el contexto de seguridad de Spring Security de una peticion a otra. 

```java
SecurityContextHolder.getContext().setAuthentication(authentication);
```

NOTA: No se guarda el contexto de seguridad de Spring Security en cada peticion, ya que la borra el filtro SecurityContextPersistenceFilter en la parte finnaly del filtro con 

```java
SecurityContextHolder.clearContext();
```
El filtro SecurityContextPersistenceFilter lo registra Spring Security por nosotros junto con mas filtros. El filtro SecurityContextPersistenceFilter se ejecuta en cada peticion antes de se ejecute nuestro BasicAuthenticationFilter (JWTAuthorizationFilter). En el log se muestra la siguiente traza en cada peticion 

```
SecurityContextHolder now cleared, as request processing completed
```



## Filtros
Por defecto Spring Security registra una serie de filtros pos nosostros:

        1.- ChannelProcessingFilter, because it might need to redirect to a different protocol

        2.- SecurityContextPersistenceFilter, so a SecurityContext can be set up in the SecurityContextHolder at the beginning of a web request, and any changes to the SecurityContext can be copied to the HttpSession when the web request ends (ready for use with the next web request)

        3.- ConcurrentSessionFilter, because it uses the SecurityContextHolder functionality but needs to update the SessionRegistry to reflect ongoing requests from the principal

        4.- Authentication processing mechanisms - UsernamePasswordAuthenticationFilter, CasAuthenticationFilter, BasicAuthenticationFilter etc - so that the SecurityContextHolder can be modified to contain a valid Authentication request token

        5.- The SecurityContextHolderAwareRequestFilter, if you are using it to install a Spring Security aware HttpServletRequestWrapper into your servlet container

        6.- RememberMeAuthenticationFilter, so that if no earlier authentication processing mechanism updated the SecurityContextHolder, and the request presents a cookie that enables remember-me services to take place, a suitable remembered Authentication object will be put there

        7.- AnonymousAuthenticationFilter, so that if no earlier authentication processing mechanism updated the SecurityContextHolder, an anonymous Authentication object will be put there

        8.- ExceptionTranslationFilter, to catch any Spring Security exceptions so that either an HTTP error response can be returned or an appropriate AuthenticationEntryPoint can be launched

        9.- FilterSecurityInterceptor, to protect web URIs and raise exceptions when access is denied

