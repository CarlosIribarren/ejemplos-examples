package oiasso.system.examples.jpa.datatables.front.helpers;

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
import org.springframework.web.client.RestTemplate;

public abstract class HateoasCallsUtilsAbstract {

	@Autowired
	private RestTemplate restTemplate;

	protected <T> ResponseEntity<PagedModel<T>> getPageable(URI uri,
			ParameterizedTypeReference<PagedModel<T>> responseType) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		return restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);
	}
}
