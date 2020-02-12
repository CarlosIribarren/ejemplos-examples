package oiasso.system.examples.jpa.datatables.front.services.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import oiasso.system.examples.jpa.datatables.back.beans.Persona;
import oiasso.system.examples.jpa.datatables.front.RestTestConfig;
import oiasso.system.examples.jpa.datatables.front.helpers.FiltroPersonas;

/**
 * TODO: Ahora mismo necesita que este el sericio de Back-end en marcha para que
 * pueda cambiar el comportamiento de la llamada restTemplate.exchange Funciona
 * el cambiar el comportamiento, pero necesita que el servicio este en marcha.
 * Estaria bien que no tuviese que estar en marcha en servicio. Es normal que se
 * tenga que estar el servicio en marcha ya que solo se ha mockeado una llamada,
 * y las otras llamadas tienen que funcionar bien.
 *
 *
 */

/**
 * Para Simplificar los test solo se valida la metadata de las respuestas
 */

@SpringBootTest
@ContextConfiguration(classes = RestTestConfig.class)
@RunWith(MockitoJUnitRunner.class)
public class PersonaServiceImplTests {

	@InjectMocks
	private PersonaServiceImpl personaService;

	// Se pone Spy para asi poder simula (mockear) la llamada al metodo interno
	// "exchange"
	@Spy
	private RestTemplate restTemplate;

	@Test
	public void getPersonasFiltered_Sin_Filtro() {

		// Preparar datos para la llamada mock

//		long size, long number, long totalElements, long totalPages

		PageMetadata metadata = new PageMetadata(5871, 647, 996321, 3587);
		List<Persona> content = new ArrayList<>();
		List<Link> links = new ArrayList<>();

		PagedModel<Persona> pagenModelRespuesta = new PagedModel<>(content, metadata, links);

		ResponseEntity<PagedModel<Persona>> responseEntity = new ResponseEntity<>(pagenModelRespuesta, HttpStatus.OK);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		final ParameterizedTypeReference<PagedModel<Persona>> responseType = new ParameterizedTypeReference<PagedModel<Persona>>() {
		};

		try {
			Mockito.when(restTemplate.exchange(new URI(
					"http://localhost:8081/api/personas/search/findByFechaBetween?inicio=2000-02-03&fin=2020-12-04&page=50&size=60&sort=id,asc"),
					HttpMethod.GET, entity, responseType)).thenReturn(responseEntity);
		} catch (RestClientException | URISyntaxException e1) {
			e1.printStackTrace();
		}

		ResponseEntity<PagedModel<Persona>> resultado = null;
		try {
			resultado = personaService.getPersonasFiltered(60, "asc", "id", 50,
					new FiltroPersonas(LocalDate.of(2000, Month.FEBRUARY, 3), LocalDate.of(2020, Month.DECEMBER, 4)));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		Assert.assertEquals("Error en el StatusCode", HttpStatus.OK, resultado.getStatusCode());
		Assert.assertEquals("Error en el getTotalElements", 996321,
				resultado.getBody().getMetadata().getTotalElements());
		Assert.assertEquals("Error en el getNumber", 647, resultado.getBody().getMetadata().getNumber());
		Assert.assertEquals("Error en el getSize", 5871, resultado.getBody().getMetadata().getSize());
		Assert.assertEquals("Error en el getTotalPages", 3587, resultado.getBody().getMetadata().getTotalPages());

	}

	@Test
	public void getPersonasFiltered_Con_Filtro() {

		// Preparar datos para la llamada mock

//		long size, long number, long totalElements, long totalPages

		PageMetadata metadata = new PageMetadata(500, 70, 80000, 4000);
		List<Persona> content = new ArrayList<>();
		List<Link> links = new ArrayList<>();

		PagedModel<Persona> pagenModelRespuesta = new PagedModel<>(content, metadata, links);

		ResponseEntity<PagedModel<Persona>> responseEntity = new ResponseEntity<>(pagenModelRespuesta, HttpStatus.OK);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		final ParameterizedTypeReference<PagedModel<Persona>> responseType = new ParameterizedTypeReference<PagedModel<Persona>>() {
		};

		try {
			Mockito.when(restTemplate.exchange(new URI("http://localhost:8081/api/personas?page=0&size=1&sort=id,asc"),
					HttpMethod.GET, entity, responseType)).thenReturn(responseEntity);
		} catch (RestClientException | URISyntaxException e1) {
			e1.printStackTrace();
		}

		ResponseEntity<PagedModel<Persona>> resultado = null;
		try {
			resultado = personaService.getPersonasFiltered(1, "asc", "id", 0, new FiltroPersonas());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		Assert.assertEquals("Error en el StatusCode", HttpStatus.OK, resultado.getStatusCode());
		Assert.assertEquals("Error en el getTotalElements", 80000,
				resultado.getBody().getMetadata().getTotalElements());
		Assert.assertEquals("Error en el getNumber", 70, resultado.getBody().getMetadata().getNumber());
		Assert.assertEquals("Error en el getSize", 500, resultado.getBody().getMetadata().getSize());
		Assert.assertEquals("Error en el getTotalPages", 4000, resultado.getBody().getMetadata().getTotalPages());

	}

}
