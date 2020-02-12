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
        Proporciona información adicional sobre servicios Swagger. 

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

    @Configuration
    @EnableSwagger2WebMvc
    @Import({ SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class })
    public class SwaggerConfiguration {



# URL de inicio
http://localhost:8081/swagger-ui.html