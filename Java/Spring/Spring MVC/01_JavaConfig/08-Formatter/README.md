# Ejemplo
En este ejemplo se muestra como utilizar un formatter de Spring.

## Probar ejemplo
Entrar en la URL: http://localhost:8080/

# Definir el formatter 
Se ha configurado un formatter para realizar la conversion para el RolDto

- El metodo "print" se llama al pintar en la plantilla
- El metodo "parse" se llama cuando se hace el post del formulario y hay que convertir de una lista de String a una lista de RolDto

```java
public class RolDtoFormatter implements Formatter<RolDto> {

	@Override
	public String print(RolDto object, Locale locale) {
		return object.getNombre();
	}

	@Override
	public RolDto parse(String text, Locale locale) throws ParseException {
		RolDto rolDto = new RolDto();
		rolDto.setNombre(text);
		return rolDto;
	}

}
```

# Registrar el formatter en el contexto 
Se registrar el formatrer a un nivel general.

```java
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new RolDtoFormatter());
    }	
```

# Uso en la plantilla
```html
<!-- Roles -->
<label for="roles">Roles</label>
<select th:field="*{roles}" id="roles" multiple="multiple" >
		    	
	<!-- Double-bracket syntax, which will automatically apply the Spring Conversion Service. -->
	<option th:each="rol : ${listadoRoles}" th:value="${{rol}}" th:utext="${rol.nombre}"/>
				
</select>
```
