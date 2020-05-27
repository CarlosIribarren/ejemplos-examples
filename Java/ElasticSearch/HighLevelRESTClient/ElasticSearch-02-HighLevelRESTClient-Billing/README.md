# Ejemplo
En este ejemplo se muestra como utilizar el cliente java oficial de ElasticSearch, sin utilizar Spring Data.
```xml
		<dependency>
			<groupId>org.elasticsearch.client</groupId>
			<artifactId>elasticsearch-rest-high-level-client</artifactId>
			<version>7.6.2</version>
		</dependency>
```

# Testing
Tiene implementado un test a modo de ejemplo.

Lo mas complicado a la hora de hacer los test, es crear un objeto SearchResponse para poder mockear la llamada. Para ello se han creado dos metodos privados.

## getSearchResponseFromJson
```java
	private SearchResponse getSearchResponseFromJson(String jsonResponse) {
		try {
			NamedXContentRegistry registry = new NamedXContentRegistry(this.getDefaultNamedXContents());
			XContentParser parser = JsonXContent.jsonXContent.createParser(registry, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, jsonResponse);
			return SearchResponse.fromXContent(parser);
		} catch (Exception e) {
			System.out.println("exception " + e);
		}
		return null;
	}
```
Este metodo se encarga de dado un JSON de entrada, generar el objeto SearchResponse. Es muy importante que el JSON de entrada tenga los tipos añadidos en las agregaciones, por ejemplo, min#minDate, donde el formato es TIPO#NOMBRE.

Es muy importante escribir asi la respuesta, para que el metodo privado getDefaultNamedXContents() de esta clase, sepa de que tipo es y pueda hacer bien la tranformacion a un objeto SearchResponse. Si no se escribe el tipo, retorna null.

Para obtener los tipos de las agregaciones,... se puede ejecutar una consulta con el parametro "typed_keys" con alguna herramienta externa. Ejemplo:
```
GET billing-*/_search?typed_keys
{
"size":0,"aggregations":{"spot_id":{"terms":{"field":"spot_id","size":10,"min_doc_count":1,"shard_min_doc_count":0,"show_term_doc_count_error":false,"order":[{"_count":"desc"},{"_key":"asc"}]},"aggregations":{"spot_name.keyword":{"terms":{"field":"spot_name.keyword","size":10,"min_doc_count":1,"shard_min_doc_count":0,"show_term_doc_count_error":false,"order":[{"_count":"desc"},{"_key":"asc"}]}}}},"minDate":{"min":{"field":"date_end"}},"maxDate":{"max":{"field":"date_start"}}}
}
```

## getDefaultNamedXContents
```java
	private List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {
		Map<String, ContextParser<Object, ? extends Aggregation>> map = new HashMap<>();
		map.put(CardinalityAggregationBuilder.NAME, (p, c) -> ParsedCardinality.fromXContent(p, (String) c));
		map.put(InternalHDRPercentiles.NAME, (p, c) -> ParsedHDRPercentiles.fromXContent(p, (String) c));
		map.put(InternalHDRPercentileRanks.NAME, (p, c) -> ParsedHDRPercentileRanks.fromXContent(p, (String) c));
		map.put(InternalTDigestPercentiles.NAME, (p, c) -> ParsedTDigestPercentiles.fromXContent(p, (String) c));
        ...
		List<NamedXContentRegistry.Entry> entries = map.entrySet().stream()
				.map(entry -> new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(entry.getKey()),
						entry.getValue()))
				.collect(Collectors.toList());
		return entries;        
    }
```
Este metodo se encarga obtener los metodos para transformar cada tipo (sterms, max, min,...) de agregacion,....

Dentro de este metodo estan añadidos casi todos los tipos, en caso de faltar algun, hay que añadirlo a la lista.

Esto es solo un ejemplo con casi todos los tipos, en un test real, se podria añadir solamente los necesarios para los test.

# Probar ejemplo

## Obtener todos los anuncios
- Realizar una peticion GET a la siguiente URL
```
http://localhost:8081/elastic/billing/filter/spots
```
- Como resultado se obtiene un JSON:
```json
{
	"list": [{
		"text": "Nike",
		"value": "1"
	}, {
		"text": "Coca Cola",
		"value": "2"
	}],
	"dates": {
		"min": "2020/01/22 04:36:00",
		"max": "2021/08/15 12:03:01"
	}
}
```

## Obtener dispositivos dado un anuncio

- Realizar una peticion GET a la siguiente URL
```
http://localhost:8081/elastic/billing/filter/devices?spotId=1
```
- Como resultado se obtiene un JSON:
```json
{
	"list": [{
		"text": "ctsdem01",
		"value": "ctsdem01"
	}, {
		"text": "ctsdem02",
		"value": "ctsdem02"
	}],
	"dates": {
		"min": "2021/07/15 01:21:01",
		"max": "2021/08/15 12:03:01"
	}
}
```

## Obtener la fecha maxima y minima de las reproduciones

- Realizar una peticion GET a la siguiente URL
```
http://localhost:8081/elastic/billing/filter/dates
```
- Como resultado se obtiene un JSON:
```json
{
	"min": "2020/01/22 04:36:00",
	"max": "2021/08/15 12:03:01"
}
```

# Preparar datos iniciales
A continuacion se muestran unas consultas de Kibana para introducir unos datos inciales

Los ejemplos mostrado anteriormente estan preparados con estos datos.
```
POST billing-2021.01.01/2
{
  "dev":"ctsdem01",
  "spot_id":1,
  "spot_name":"Nike",
  "date_start":"2021/07/15 01:01:01",
  "date_end":"2021/07/15 01:21:01"
}

POST billing-2021.01.01/2
{
  "dev":"ctsdem02",
  "spot_id":1,
  "spot_name":"Nike",
  "date_start":"2021/08/15 12:03:01",
  "date_end":"2021/08/15 12:56:02"
}

POST billing-2021.01.01/2
{
  "dev":"ctsdem01",
  "spot_id":2,
  "spot_name":"Coca Cola",
  "date_start":"2020/01/22 04:34:41",
  "date_end":"2020/01/22 04:36:00"
}
```