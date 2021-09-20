# Swagger 

En este ejemplo se muestra como definir los parametros de entrada de forma general para las peticiones con el objeto Pageable.

Swagger sustituye la clase Pageable por la clase SwaggerPageable, de tal forma que esta tiene los 3 atributos que las clase Pageable necesita.

## URL de inicio
```
http://localhost:8081/swagger-ui.html
```


# Configuracion

## SwaggerPageable
Crear una clase de sustitucion (tiene que tener los metodo Get y Set)
```java
@ApiModel
public class SwaggerPageable {
		
	    @ApiModelProperty(value = "Tamaño de la pagina que queremos obtener", example = "10")
	    private Integer size;
	    
	    @ApiModelProperty(value = "Pagina de registros que queremos obtener (0..N)", example = "0")
	    private Integer page;
	    		
	    @ApiModelProperty(value = "Criterios de ordenacion en el formato: propiedad(,asc|desc). El orden de clasificación predeterminado es ascendente. Se admiten varios criterios de ordenacion.", example = "idPuntoRecarga,asc")
	    private String sort;

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}
	    
}
```
## Configurar para que sustituya la clase Pageable por la clase SwaggerPageable
```java
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket usersApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(usersApiInfo())
				.select()
				.paths(userPaths())
				.apis(RequestHandlerSelectors.any())
				.build()
				.directModelSubstitute(Pageable.class, SwaggerPageable.class);
	}
```


# Forma alternativa
Sin no se hace de esta manera, tambien se podria en cada metodo definir los siguientes atributos:
```java
    @ApiOperation(value = "Find partners")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                value = "Results page you want to retrieve (0..N)"),
        @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                value = "Sorting criteria in the format: property(,asc|desc). " +
                        "Default sort order is ascending. " +
                        "Multiple sort criteria are supported.")
    })
    @RequestMapping(value = "/v1/partners", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Partner> findAll(@ApiIgnore final Pageable pageable) {
```

Esta forma es peor, ya que carga mucho visualmente los metodos, se repite en todos,....


