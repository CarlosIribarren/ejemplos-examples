package oiasso.systems.elastic.client.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;

import oiasso.systems.elastic.client.exception.ElasticSearchConsultException;

public interface ElasticSearchService {

	/**
	 * Execute search request to ElasticSearch data base
	 * 
	 * @param searchRequest Search request
	 * @param options       Options of request
	 * @return SearchResponse object with the result of the request
	 * @throws ElasticSearchConsultException
	 */
	SearchResponse executeSearchRequest(SearchRequest searchRequest, RequestOptions options)
			throws ElasticSearchConsultException;

}
