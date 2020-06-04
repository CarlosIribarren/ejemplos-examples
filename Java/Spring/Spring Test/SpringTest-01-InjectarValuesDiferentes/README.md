# Ejemplo
En este ejemplo se muestra como injectar un @Value en una clase de test con diferentes valores.

Para ello en la clase original, se ha definido un constructor donde se injecta el @Value.

```java
@Component
public class ElasticSearchRequestFactory {

	private final String node;
	
	@Autowired
	public ElasticSearchRequestFactory(@Value("${ads.elasticsearch.node.url}") final String node) {
		super();
		this.node = node;
	}
```

De esta manera, cuando hacemos el test, no tenemos que levantar el contexto de Spring para injectar la propiedad, y tambien podemos darle diferentes valores en cada test, para ello solo hay que instanciar la clase con el parametro que se quiere:

```java
	private ElasticSearchRequestFactory elasticSearchRequestFactory;
	
	@Before
	public void setUp() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("");
	}
	
	@Test
	public void isNodePropertyDisabled_disabled() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("disabled");
		Assert.assertTrue(elasticSearchRequestFactory.isNodePropertyDisabled());
	}
	
	@Test
	public void isNodePropertyDisabled_enabled() {
		Assert.assertFalse(elasticSearchRequestFactory.isNodePropertyDisabled());
	}	
	
	@Test
	public void createSearchURL() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("http://192.168.242.116:9200");
		Assert.assertEquals("http://192.168.242.116:9200/billing-*/_search", elasticSearchRequestFactory.createSearchURL());
	}
```

- El primer test, utiliza una instancia de la clase con el String "disabled", ya que se necesita ese valor para esa prueba concreta.
- El segundo test, utiliza una instancia de la clase con cualquier String.
- El tercer test, utiliza una instancia de la clase con el String "http://192.168.242.116:9200", ya que se necesita ese valor para esa prueba concreta.

## Conclusion
Injectar atributos por el constructor es una buena practica, ya que favorece el desarrollo de los test:
- No se necesita levantar el contexto para injectar un atributo concreto.
- Se le pueden dar diferentes valores a los atributos en cada test.
- Para los unitarios no hace falta levantar el contexto de spring, con mockear la capa inferior es suficiente. El contexto de spring se tiene que levantar cuando ejecutamos test de integracion.