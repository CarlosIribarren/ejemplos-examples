package oiasso.system.examples.jpa.datatables.front.services.impl;

import java.net.URISyntaxException;
import java.time.LocalDate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import oiasso.system.examples.jpa.datatables.back.beans.Persona;
import oiasso.system.examples.jpa.datatables.front.helpers.FiltroPersonas;
import oiasso.system.examples.jpa.datatables.front.helpers.HateoasCallsUtilsAbstract;
import oiasso.system.examples.jpa.datatables.front.services.PersonaService;

@Service
public class PersonaServiceImpl extends HateoasCallsUtilsAbstract implements PersonaService {

	@Override
	public ResponseEntity<PagedModel<Persona>> getPersonasFiltered(Integer elementosPorPagina, String sortDirection,
			String sortColumnName, Integer numeroDePagina, FiltroPersonas filtroPersonas) throws URISyntaxException {

		// Llamar un servicio REST y devolver el resultado
		// Execute the request specified in the given RequestEntity and returnthe
		// response as ResponseEntity. The given ParameterizedTypeReference is used to
		// pass generic type information

		// Se realiza una llamada GET con parametros en la URL

		LocalDate fechaInicio = filtroPersonas.getFechaInicio();
		LocalDate fechaFin = filtroPersonas.getFechaFin();

		UriComponentsBuilder builder;

		if (fechaInicio != null && fechaFin != null) {
			// Los parametros de la URL se tiene que llamar como estan definidos en los
			// atributos del metodo, y son obligatorios, si no llegan a la API da error
			// Ejemplo: findByFechaBetween(LocalDate inicio, LocalDate fin ...)
			builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/personas/search/findByFechaBetween")
					.queryParam("inicio", fechaInicio.toString()).queryParam("fin", fechaFin.toString());
		} else {
			builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/personas");
		}
		builder.queryParam("page", numeroDePagina.toString()).queryParam("size", elementosPorPagina.toString())
				.queryParam("sort", sortColumnName + "," + sortDirection).build();

		return getPageable(builder.build().toUri(), new ParameterizedTypeReference<PagedModel<Persona>>() {
		});
	}

//	@Override
//	public ResponseEntity<PagedModel<Persona>> getPersonas(Integer elementosPorPagina, String sortDirection,
//			String sortColumnName, Integer numeroDePagina, FiltroPersonas filtroPersonas) throws URISyntaxException {
//
//		// Llamar un servicio REST y devolver el resultado
//		// Execute the request specified in the given RequestEntity and returnthe
//		// response as ResponseEntity. The given ParameterizedTypeReference is used to
//		// pass generic type information
//
//		// Se realiza una llamada GET con parametros en la URL
//
//		LocalDate fechaInicio = filtroPersonas.getFechaInicio();
//		LocalDate fechaFin = filtroPersonas.getFechaFin();
//
//		UriComponentsBuilder builder;
//
//		if (fechaInicio != null && fechaFin != null) {
//			// Los parametros de la URL se tiene que llamar como estan definidos en los
//			// atributos del metodo, y son obligatorios, si no llegan a la API da error
//			// Ejemplo: findByFechaBetween(LocalDate inicio, LocalDate fin ...)
//			builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/personas/search/findByFechaBetween")
//					.queryParam("inicio", fechaInicio.toString()).queryParam("fin", fechaFin.toString());
//		} else {
//			builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/personas");
//		}
//		builder.queryParam("page", numeroDePagina.toString()).queryParam("size", elementosPorPagina.toString())
//				.queryParam("sort", sortColumnName + "," + sortDirection).build();
//
////		ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
//
//		// ***********************************************
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<>("body", headers);
//		final ParameterizedTypeReference<PagedModel<Persona>> responseType = new ParameterizedTypeReference<PagedModel<Persona>>() {
//		};
//
//		ResponseEntity<PagedModel<Persona>> response = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,
//				entity, responseType);
//
//		return response;
//	}

}
