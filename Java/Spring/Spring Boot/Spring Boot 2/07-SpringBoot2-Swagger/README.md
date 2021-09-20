# Swagger 
Swagger es un framework que resulta muy útil para documentar, visualizar y consumir servicios REST . El objetivo de Swagger es que la documentación del API RESTFul se vaya actualizando cada vez que se realicen cambios en el servidor.

Este framework ofrece una interfaz visual a modo de sandbox que permite probar las llamadas a las operaciones del API RESTFul así como consultar su documentación (métodos, parámetros y estructura JSON del modelo)

# Anotaciones de Swagger

## - Modelos/Beans/DTOs...

    - @ApiModel 
        Proporciona información adicional sobre modelos Swagger. 

    - @ApiModelProperty
        Permite describir una propiedad de una clase del modelo e indicar, por ejemplo, si éste es o no obligatorio.

## - Servicios

    - @Api
        Sirve para definir un Controlador.

        Con la propiedad "tags" se define el nombre: @Api(tags="Customer Controller")

    - @ApiOperation
        Permite describir un servicio.

## - Validaciones de Beans

Para que en la interface grafica funcionen las validaciones de los Beans, tipo @NotNull,....

Hay que añadir la siguiente dependecia

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-bean-validators</artifactId>
        <version>2.9.2</version>
    </dependency>

Añadir el Imoprt de BeanValidatorPluginsConfiguration.class en la configuracion de SwaggerConfiguration.
```java
    @Configuration
    @EnableSwagger2WebMvc
    @Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class })
    public class SwaggerConfiguration {
```

# URL de inicio
http://localhost:8081/swagger-ui.html



# Documentar un POST

## Atributos obligatorios/opcionales 
Es importante añadir la clase de configuracion BeanValidatorPluginsConfiguration.class
```java
    @Configuration
    @EnableSwagger2WebMvc
    @Import(BeanValidatorPluginsConfiguration.class)
    public class SwaggerConfiguration {
```
Para que cuando anotemos un atributo con la anotacion de @ApiModelProperty, este configuracion se refleje en swager:

A continuacion se muestra un ejemplo:

Al relaizar un POST, algunos campos del DTO son obligatorios y otros opcionales. Para ello anotamos los atributos con la anotacion @ApiModelProperty:

```java
	@ApiModelProperty(required = true)
	@NotNull
	private String email;

	@ApiModelProperty(required = false)
	private String tlf;
```

En la interface de swager esto se refleja poniendo un asterisco (*) en el atributo del model. 

```
email*	string
tlf	    string
```

En la interface de swager al ejecutar el POST, no impide que se ejecute. 

Como el atributo esta marcado con @NotNull dara un error 400 informando que el atributo es obligatorio, entonces el programador mira el modelo y verifica con el asterisco que es obligatorio.

## Ejemplo de los atributos
Es importante añadir la propiedad "example" cuando documentamos los atributos del modelo:
```java
	@ApiModelProperty(required = true, example = "example@email.com")
	@NotNull
	private String email;
```
De esta manera en la interface de swager, al ir a realizar la prueba, ese atributo ya tiene el valor de example. Siempre se puede modificar el valor.

# Agrupaciones de metodos,...
En la configuracion, si definimos varios Bean y cada uno con un grupo ("groupName") diferente, estos se muestran en el combo.
```java
    @Bean
    public Docket swaggerSettingsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Settings")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xyz"))
                .paths(regex("/secure/api/v1/settings/.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Settings API").build())
                .globalOperationParameters(operationParameters());
    }

    @Bean
    public Docket swaggerProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Product")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xyz.modules.v1"))
                .paths(productPaths())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Product API").build())
                .globalOperationParameters(operationParameters());
    }

    @Bean
    public Docket swaggerModuleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Others")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xyz.modules.v1"))
                .paths(postPaths())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Other Modules API").build())
                .globalOperationParameters(operationParameters());
    }

      private Predicate<String> postPaths() {
        return or(regex("^(?=\\/secure\\/api\\/v1\\/)(?!.*(settings|products)).+\\/.*"));
    }
```