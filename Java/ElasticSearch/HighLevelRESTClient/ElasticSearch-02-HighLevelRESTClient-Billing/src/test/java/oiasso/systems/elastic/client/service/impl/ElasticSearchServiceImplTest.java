package com.ikusi.ads.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.ikusi.ads.exception.ElasticSearchConsultException;

public class ElasticSearchServiceImplTest {

	private ElasticSearchServiceImpl elasticSearchServiceImpl;
	
	private RestHighLevelClient restHighLevelClient;
	
	@Test
	public void executeSearchRequest() throws ElasticSearchConsultException, IOException {
		restHighLevelClient = mock(RestHighLevelClient.class);
		elasticSearchServiceImpl = new ElasticSearchServiceImpl(restHighLevelClient);
		elasticSearchServiceImpl.executeSearchRequest(any(SearchRequest.class), any(RequestOptions.class));
		verify(restHighLevelClient, times(1)).search(any(SearchRequest.class), any(RequestOptions.class));
	}
	
	@Test(expected = ElasticSearchConsultException.class)
	public void executeSearchRequest_ElasticSearchConsultException() throws ElasticSearchConsultException {
		restHighLevelClient = new RestHighLevelClient(RestClient.builder("aaa"));
		elasticSearchServiceImpl = new ElasticSearchServiceImpl(restHighLevelClient);
		elasticSearchServiceImpl.executeSearchRequest(any(SearchRequest.class), any(RequestOptions.class));
	}
	
}
