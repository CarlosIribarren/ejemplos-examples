package oiasso.systems.elastic.example.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.factory.ElasticSearchRequestFactory;

public class ElasticSearchRequestServiceImplTest {

	private static final String SEARCH_URL = "mockSearchUrl";
	
	private static final String SEARCH_RESPONSE = "{\"hits\":{\"total\":{\"value\":27}}}";
	
	@InjectMocks
	private ElasticSearchRequestServiceImpl elasticSearchRequestServiceImpl;
	
	@Mock
	private RestTemplate restTemplate;

	@Mock
	private ElasticSearchRequestFactory requestFactory;
	
	@Before
	public void setUp() throws ElasticSearchConsultException {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = ElasticSearchConsultException.class)
	public void executeSearchRequest_when_node_property_is_disabled_should_throw_exception() throws ElasticSearchConsultException {
		when(requestFactory.isNodePropertyDisabled()).thenReturn(true);
		elasticSearchRequestServiceImpl.executeSearchRequest("");
	}
	
	@Test(expected = ElasticSearchConsultException.class)
	public void executeSearchRequest_when_response_is_bad_answer_should_throw_exception() throws ElasticSearchConsultException {
		when(requestFactory.isNodePropertyDisabled()).thenReturn(false);
		when(requestFactory.createSearchURL()).thenReturn(SEARCH_URL);
		final HttpEntity<String> mockRequestEntity = new HttpEntity<String>("");
		when(requestFactory.createRequestEntity(anyString())).thenReturn(mockRequestEntity);
		final ResponseEntity<String> responseMock = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		when(restTemplate.postForEntity(any(String.class), any(HttpEntity.class), eq(String.class))).thenReturn(responseMock);
		when(requestFactory.isBadAnswer(Matchers.<ResponseEntity<String>> any())).thenReturn(true);

		elasticSearchRequestServiceImpl.executeSearchRequest("");
	}
	
	
	@Test(expected = ElasticSearchConsultException.class)
	public void executeSearchRequest_when_an_error_occurs_while_executing_the_query_should_throw_exception() throws ElasticSearchConsultException {
		when(requestFactory.isNodePropertyDisabled()).thenReturn(false);
		when(requestFactory.createSearchURL()).thenReturn(SEARCH_URL);
		final HttpEntity<String> mockRequestEntity = new HttpEntity<String>("");
		when(requestFactory.createRequestEntity(anyString())).thenReturn(mockRequestEntity);
		when(restTemplate.postForEntity(any(String.class), any(HttpEntity.class), eq(String.class))).thenThrow(new RestClientException(""));

		elasticSearchRequestServiceImpl.executeSearchRequest("");
	}
	
	@Test(expected = ElasticSearchConsultException.class)
	public void executeSearchRequest__when_an_error_occurs_while_parse_response_to_json_should_throw_exception() throws ElasticSearchConsultException {
		when(requestFactory.isNodePropertyDisabled()).thenReturn(false);
		when(requestFactory.createSearchURL()).thenReturn(SEARCH_URL);
		final HttpEntity<String> mockRequestEntity = new HttpEntity<String>("");
		when(requestFactory.createRequestEntity(anyString())).thenReturn(mockRequestEntity);
		final ResponseEntity<String> responseMock = new ResponseEntity<String>("responseMock",HttpStatus.OK);
		when(restTemplate.postForEntity(any(String.class), any(HttpEntity.class), eq(String.class))).thenReturn(responseMock);

		elasticSearchRequestServiceImpl.executeSearchRequest("");
	}
	
	@Test
	public void executeSearchRequest_when_all_chek_are_ok_and_response_format_is_json_should_return_response() throws ElasticSearchConsultException, JsonProcessingException, IOException {
		when(requestFactory.isNodePropertyDisabled()).thenReturn(false);
		when(requestFactory.createSearchURL()).thenReturn(SEARCH_URL);
		final HttpEntity<String> mockRequestEntity = new HttpEntity<String>("");
		when(requestFactory.createRequestEntity(anyString())).thenReturn(mockRequestEntity);
		final ResponseEntity<String> responseMock = new ResponseEntity<String>(SEARCH_RESPONSE,HttpStatus.OK);
		when(restTemplate.postForEntity(any(String.class), any(HttpEntity.class), eq(String.class))).thenReturn(responseMock);
		when(requestFactory.isBadAnswer(Matchers.<ResponseEntity<String>> any())).thenReturn(false);

		final ObjectMapper mapper = new ObjectMapper();
		final JsonNode expected = mapper.readTree(SEARCH_RESPONSE); 
		
		final JsonNode actual = elasticSearchRequestServiceImpl.executeSearchRequest("");
		
		assertEquals(expected, actual);
	}
	
	
}
