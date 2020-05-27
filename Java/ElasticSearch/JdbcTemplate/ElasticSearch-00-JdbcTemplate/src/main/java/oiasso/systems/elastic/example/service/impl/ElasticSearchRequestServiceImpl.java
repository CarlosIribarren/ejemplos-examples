package oiasso.systems.elastic.example.service.impl;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.factory.ElasticSearchRequestFactory;
import oiasso.systems.elastic.example.service.ElasticSearchRequestService;

@Service
public class ElasticSearchRequestServiceImpl implements ElasticSearchRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchRequestServiceImpl.class);
	
	private final RestTemplate restTemplate;

	private final ElasticSearchRequestFactory requestFactory;
	
	@Autowired
	public ElasticSearchRequestServiceImpl(final RestTemplate restTemplate, final ElasticSearchRequestFactory requestFactory) {
		super();
		this.restTemplate = restTemplate;
		this.requestFactory = requestFactory;
	}

	@Override
	public JsonNode executeSearchRequest(final String query) throws ElasticSearchConsultException {

		// Verify property
		if(requestFactory.isNodePropertyDisabled()) {
			throw new ElasticSearchConsultException("ElasticSearch node is disabled. Please check de property [ads.elasticsearch.node.url] on file [ads-config.properties] and define one node.", new RuntimeException());
		}

		final String url = requestFactory.createSearchURL();
		final HttpEntity<String> request = requestFactory.createRequestEntity(query);

		// Execute search request
		LOGGER.info("Executing ElasticSearch query : {} , {}",url, query);
		ResponseEntity<String> response;
		try {
			response = restTemplate.postForEntity(url, request, String.class);
		} catch (final Exception e) {
			throw new ElasticSearchConsultException("Error executing ElasticSearch consult", e);
		}

		if(requestFactory.isBadAnswer(response)) {
			throw new ElasticSearchConsultException("ElasticSearch Http response code is not OK (200). "
					+ "Request call [POST: " + url  + " ] with body: " + query + "."  
					+ "Response code: " + response.getStatusCode() + ". Body of error: " + response.getBody(), new RuntimeException());
		}

		try {
			return new ObjectMapper().readTree(response.getBody());
		} catch (final Exception e) {
			throw new ElasticSearchConsultException("Error on parse ElasticSearch result", e);
		}
	}

}
