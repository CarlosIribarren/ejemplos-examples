package oiasso.systems.elastic.client.service.impl;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.elastic.client.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.client.service.ElasticSearchService;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchServiceImpl.class);

	private RestHighLevelClient client;

	@Autowired
	public ElasticSearchServiceImpl(RestHighLevelClient client) {
		super();
		this.client = client;
	}

	@Override
	public SearchResponse executeSearchRequest(SearchRequest searchRequest, RequestOptions options)
			throws ElasticSearchConsultException {
		try {
			LOGGER.info("Executing search request: {} ", searchRequest.toString());
			return client.search(searchRequest, options);
		} catch (IOException | ElasticsearchException e) {
			throw new ElasticSearchConsultException("Error getting spot names", e);
		}
	}

}
