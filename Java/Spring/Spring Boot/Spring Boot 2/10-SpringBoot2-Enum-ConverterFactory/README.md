# 10-SpringBoot2-Enum-ConverterFactory
Ejemplo de como utilizar los enum para una API REST. 

Este ejemplo se centra en la comunicacion de los ENUM entre las llamadas a los servicios y las respuestas de estos.

Es decir, en este ejemplo se muestra el Binding de un ENUM y al responder que valor se asigna en el JSON.

Los enum tiene dos valores, el nombre de cada ENUM (HOURLY_EJEMPLO), y el valor (hourly-example):

```java
public enum GranularityEnum {

    HOURLY_EJEMPLO("hourly-example"),
    DAILY_EJEMPLO("daily-example"),
    MONTHLY_EJEMPLO("monthly-example"),
    YEARLY_EJEMPLO("yearly-example");
	
	private String value;
	
    private GranularityEnum(final String value) {
		this.value = value;
	}

    @JsonValue
	@Override
	public String toString() {
		return value;
	}

}
```

En nombre del ENUM (HOURLY_EJEMPLO) lo utilizamos dentro de las clases java para comparar,...

Y el valor de ENUM (hourly-example) lo utilizamos en el mundo exterior, es decir, lo utilizamos para recibir como valor de una rquest en forma de parametro.

Y tambien lo utilizamos para utilizarlo a la hora de responder el enum para darle un valor.

Si nos fijamos bien, el nombre del ENUM y el valor no son iguales.

Para que cuando en una peticion Spring convierta el String en un ENUM se ha definido un ConverterFactory que utiliza un Converter:

```java
@Component
public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {
 
    private static class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
 
        private final Class<T> enumType;
 
        public StringToEnumConverter(final Class<T> enumType) {
            this.enumType = enumType;
        }
 
        @Override
		public T convert(final String source) {
        	
            if (null == source) {
                return null;
            }
        	
        	for (final T a : enumType.getEnumConstants()) {
				if(a.toString().equalsIgnoreCase(source)) {
					return a;
				}
			}

            throw new IllegalArgumentException("Unknown value for enum : " + enumType.getName() + ". Unknown value is : " + source);
        }
    }
 
    @Override
    public <T extends Enum> Converter<String, T> getConverter(final Class<T> targetType) {
        return new StringToEnumConverter(targetType);
    }
}

```

En el enum se ha definido el metodo de toString() para que al crear la instancia del ENUM concreto, (cuando viene en una peticion) se busque y compare con el toString()

```java
        	for (final T a : enumType.getEnumConstants()) {
				if(a.toString().equalsIgnoreCase(source)) {
					return a;
				}
			}
```
De esta forma estamos creando (convirtiendo) un ENUM, cuando el valor que viene es igual al valor de ENUM.

Y en el controler el binding se hace automaticamente gracias al converter:

```java
	public ResponseEntity<ResponseDto> example(
			@ApiParam(value = "Granularity", required = true)
			@PathVariable(required = true) final GranularityEnum granularity){
```

## Responder el ENUM

Cuando respondemos un ENUM, interesa responder con el valor del ENUM (hourly-example) y no el nombre (HOURLY_EJEMPLO).

Para ello ponermos la anotacion @JsonValue en el metodo toString(), para indicar que cuando tenga que crear un json utilice ese metodo para darle el valor.

De esta manera se consigue que cuando enviamos un ENUM al cliente, se envie el valor del ENUM (hourly-example)

```json
{
  "granularity": "hourly-example",
  "tipo": "Es de tipo Hourly. Ejemplo para utilizar el enum en las clases java"
}
```

## En las clases JAVA

En la clases java se utiliza el nombre del ENUM (HOURLY_EJEMPLO), para que sea mas sencillo:

```java
		if(granularity.equals(GranularityEnum.HOURLY_EJEMPLO)) {
			responseDto.setTipo("Es de tipo Hourly. Ejemplo para utilizar el enum en las clases java");
		}
```


## Url de inicio
http://localhost:8080/

## Notas
Se podria añadir un atributo mas en el ENUM, por si queremos guardar un valor numerico,...o mas atributos.