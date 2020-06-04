package oiasso.systems.spring.test.factory;

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

	private ElasticSearchRequestFactory elasticSearchRequestFactory;
	
	@Before
	public void setUp() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("");
	}
	
	@Test
	public void isNodePropertyDisabled_disabled() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("disabled");
		Assert.assertTrue(elasticSearchRequestFactory.isNodePropertyDisabled());
	}
	
	@Test
	public void isNodePropertyDisabled_enabled() {
		Assert.assertFalse(elasticSearchRequestFactory.isNodePropertyDisabled());
	}	
	
	@Test
	public void createSearchURL() {
		elasticSearchRequestFactory = new ElasticSearchRequestFactory("http://192.168.242.116:9200");
		Assert.assertEquals("http://192.168.242.116:9200/billing-*/_search", elasticSearchRequestFactory.createSearchURL());
	}
	
	@Test
	public void createRequestEntity_ok() {
		// Prepare
		final JSONObject jSONObject = new JSONObject("{\"size\": 0 }");
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> expected = new HttpEntity<>(jSONObject.toString(), headers);
		
		// Execute
		final HttpEntity<String> actual = elasticSearchRequestFactory.createRequestEntity("{\"size\": 0 }");
		
		// Assert
		Assert.assertEquals(expected, actual);		
	}
	
	@Test(expected = JSONException.class)
	public void createRequestEntity_error() {
		elasticSearchRequestFactory.createRequestEntity("");
	}
	
	@Test
	public void isBadAnswer_true() {
		Assert.assertTrue(elasticSearchRequestFactory.isBadAnswer(new ResponseEntity<String>(HttpStatus.GATEWAY_TIMEOUT)));
	}
	
	@Test
	public void isBadAnswer_false() {
		Assert.assertFalse(elasticSearchRequestFactory.isBadAnswer(new ResponseEntity<String>(HttpStatus.OK)));
	}
}
