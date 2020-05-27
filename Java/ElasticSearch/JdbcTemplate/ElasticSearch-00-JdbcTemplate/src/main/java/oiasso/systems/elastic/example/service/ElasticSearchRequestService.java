package oiasso.systems.elastic.example.service;

import org.codehaus.jackson.JsonNode;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;

public interface ElasticSearchRequestService {

	/**
	 * Execute search request to ElasticSearch data base
	 * 
	 * @param query Query
	 * @return JsonNode object with the response.
	 * @throws ElasticSearchConsultException
	 */
	JsonNode executeSearchRequest(String query) throws ElasticSearchConsultException;
	
}
