package oiasso.system.listadocoches.datatables.front.abstracts;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import oiasso.system.listadocoches.datatables.front.exception.ListadoCochesRestApiException;

/**
 * Clase generica para relalizar las llamadas hacia el back-end. Retorna objetos del tipo Hateoas (PageModel,...)
 */
public abstract class HateoasCallsUtilsAbstract {

	@Autowired
	private RestTemplate restTemplate;

	protected <T> ResponseEntity<PagedModel<T>> getPageable(URI uri, ParameterizedTypeReference<PagedModel<T>> responseType) throws ListadoCochesRestApiException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		try {
			return restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);
		} catch (RestClientException e) {
			throw new ListadoCochesRestApiException("Error al llamar a la URL del API: " + uri.toString(), e)  ;
		}
	}
}
