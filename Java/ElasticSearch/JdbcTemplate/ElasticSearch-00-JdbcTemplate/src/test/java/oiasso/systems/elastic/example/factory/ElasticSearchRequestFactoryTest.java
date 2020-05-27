package oiasso.systems.elastic.example.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ElasticSearchRequestFactoryTest {

	private static final String REQUEST_ENTITY = "{\"size\": 0 }";
	
	private static final String NODE_HOST = "http://192.168.242.116:9200";
	
	private ElasticSearchRequestFactory elasticSearchRequestFactory;
	
	@Before
	public void setUp() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("");
	}
	
	@Test
	public void isNodePropertyDisabled_when_node_url_property_is_disabled_should_return_true() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("disabled");
		Assert.assertTrue(elasticSearchRequestFactory.isNodePropertyDisabled());
	}
	
	@Test
	public void isNodePropertyDisabled_when_node_url_property_have_any_value_should_return_false() {
		Assert.assertFalse(elasticSearchRequestFactory.isNodePropertyDisabled());
	}	
	
	@Test
	public void createSearchURL_should_return_concatenation_of_the_node_and_search_url() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory(NODE_HOST);
		Assert.assertEquals(NODE_HOST + "/billing-*/_search", elasticSearchRequestFactory.createSearchURL());
	}
	
	@Test
	public void createRequestEntity_should_return_http_entity_with_content_type_json() {
		final JSONObject jSONObject = new JSONObject(REQUEST_ENTITY);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> expected = new HttpEntity<>(jSONObject.toString(), headers);
		
		final HttpEntity<String> actual = elasticSearchRequestFactory.createRequestEntity(REQUEST_ENTITY);
		
		assertEquals(expected, actual);		
	}
	
	@Test(expected = JSONException.class)
	public void createRequestEntity_when_query_not_has_json_format_should_throw_exception() {
		elasticSearchRequestFactory.createRequestEntity("");
	}
	
	@Test
	public void isBadAnswer_when_response_status_is_not_ok_should_return_true() {
		assertTrue(elasticSearchRequestFactory.isBadAnswer(new ResponseEntity<String>(HttpStatus.GATEWAY_TIMEOUT)));
	}
	
	@Test
	public void isBadAnswer_when_response_status_is_ok_should_return_false() {
		assertFalse(elasticSearchRequestFactory.isBadAnswer(new ResponseEntity<String>(HttpStatus.OK)));
	}
}
