package oiasso.system.listadocoches.datatables.front.services.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.PagedModel.PageMetadata;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.datatables.front.beans.FiltroCoche;
import oiasso.system.listadocoches.datatables.front.controller.CocheController;
import oiasso.system.listadocoches.datatables.front.exception.ListadoCochesRestApiException;
import oiasso.system.listadocoches.datatables.front.services.impl.CocheServiceImpl;
import oiasso.system.listadocoches.datatables.front.variables.VariablesEntornoListadoCochesWEB;

/**
 * TODO: Ahora mismo necesita que este el sericio de Back-end en marcha para que
 * pueda cambiar el comportamiento de la llamada restTemplate.exchange Funciona
 * el cambiar el comportamiento, pero necesita que el servicio este en marcha.
 * Estaria bien que no tuviese que estar en marcha el servicio. Es normal que 
 * tenga que estar el servicio en marcha ya que solo se ha mockeado una llamada,
 * y las otras llamadas tienen que funcionar bien.
 */

/**
 * Para Simplificar los test solo se valida la metadata de las respuestas.
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CocheServiceImplTests {

	private static final Logger LOG = LoggerFactory.getLogger(CocheController.class);
	
	// *********************
	// ***** Atributos *****
	// *********************
	
	@Autowired
	private VariablesEntornoListadoCochesWEB variablesEntornoListadoCochesWEB; 

	// *********************
	// ******* Mocks *******
	// *********************
	
	@Autowired
	@InjectMocks
	private CocheServiceImpl cocheService;

	@Autowired
	@Spy
	private RestTemplate restTemplate;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

	}

	// *********************
	// ******* Tests *******
	// *********************
	
	@Test
	public void getCochesFiltered_Sin_Filtro() {

		// Preparar respuesta para la llamada mock
		PagedModel<Coche> pageModelRespuesta = prepararPagedModelSoloConMetadata(5871, 647, 996321, 3587);
		ResponseEntity<PagedModel<Coche>> responseEntity = new ResponseEntity<>(pageModelRespuesta, HttpStatus.OK);
		HttpEntity<String> entity = prepararHttpEntityVacio();
		final ParameterizedTypeReference<PagedModel<Coche>> responseType = new ParameterizedTypeReference<PagedModel<Coche>>() {
		};

		// Mockear la llamda al back-end
		try {
			Mockito.when(restTemplate.exchange(new URI(
					variablesEntornoListadoCochesWEB.getApiCochesHost() + "/api/coche/search/findByFechaMatriculacionBetween?inicio=2000-02-03&fin=2020-12-04&page=50&size=60&sort=id,asc"),
					HttpMethod.GET, entity, responseType)).thenReturn(responseEntity);
		} catch (RestClientException | URISyntaxException e1) {
			LOG.error("Error al mockear el restTemplate", e1);
		}

		// Realizar la prueba
		ResponseEntity<PagedModel<Coche>> resultado = null;
		try {
			resultado = cocheService.getCochesFiltered(60, "asc", "id", 50, new FiltroCoche(LocalDate.of(2000, Month.FEBRUARY, 3), LocalDate.of(2020, Month.DECEMBER, 4)));
		} catch (ListadoCochesRestApiException e) {
			LOG.error("Error al obtener el listado de coches",e);
		}

		// Verificar resultados
		Assert.assertEquals("Error en el StatusCode", HttpStatus.OK, resultado.getStatusCode());
		Assert.assertEquals("Error en el getTotalElements", 996321, resultado.getBody().getMetadata().getTotalElements());
		Assert.assertEquals("Error en el getNumber", 647, resultado.getBody().getMetadata().getNumber());
		Assert.assertEquals("Error en el getSize", 5871, resultado.getBody().getMetadata().getSize());
		Assert.assertEquals("Error en el getTotalPages", 3587, resultado.getBody().getMetadata().getTotalPages());

	}


	@Test
	public void getCochesFiltered_Con_Filtro() {

		// Preparar datos para la llamada mock
		PagedModel<Coche> pageModelRespuesta = prepararPagedModelSoloConMetadata(500, 70, 80000, 4000);
		ResponseEntity<PagedModel<Coche>> responseEntity = new ResponseEntity<>(pageModelRespuesta, HttpStatus.OK);
		HttpEntity<String> entity = prepararHttpEntityVacio();
		final ParameterizedTypeReference<PagedModel<Coche>> responseType = new ParameterizedTypeReference<PagedModel<Coche>>() {
		};

		// Mockear la llamda al back-end
		try {
			Mockito.when(
					restTemplate.exchange(new URI(variablesEntornoListadoCochesWEB.getApiCochesHost() + "/api/coche?page=0&size=1&sort=id,asc"),
							HttpMethod.GET, entity, responseType))
			.thenReturn(responseEntity);
		} catch (RestClientException | URISyntaxException e1) {
			LOG.error("Error al mockear el restTemplate", e1);
		}

		// Realizar la prueba
		ResponseEntity<PagedModel<Coche>> resultado = null;
		try {
			resultado = cocheService.getCochesFiltered(1, "asc", "id", 0, new FiltroCoche());
		} catch (ListadoCochesRestApiException e) {
			LOG.error("Error al obtener el listado de coches",e);
		}

		// Verificar resultados
		Assert.assertEquals("Error en el StatusCode", HttpStatus.OK, resultado.getStatusCode());
		Assert.assertEquals("Error en el getTotalElements", 80000, resultado.getBody().getMetadata().getTotalElements());
		Assert.assertEquals("Error en el getNumber", 70, resultado.getBody().getMetadata().getNumber());
		Assert.assertEquals("Error en el getSize", 500, resultado.getBody().getMetadata().getSize());
		Assert.assertEquals("Error en el getTotalPages", 4000, resultado.getBody().getMetadata().getTotalPages());
	}


	// *********************
	// ** Metodos privados *
	// *********************

	private PagedModel<Coche> prepararPagedModelSoloConMetadata(long size, long number, long totalElements, long totalPages) {
		PageMetadata metadata = new PageMetadata(size, number, totalElements, totalPages);
		List<Coche> content = new ArrayList<>();
		List<Link> links = new ArrayList<>();
		return new PagedModel<>(content, metadata, links);
	}

	private HttpEntity<String> prepararHttpEntityVacio() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		return entity;
	}

}
