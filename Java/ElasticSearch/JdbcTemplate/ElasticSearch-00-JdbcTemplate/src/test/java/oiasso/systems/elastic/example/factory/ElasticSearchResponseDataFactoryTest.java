package oiasso.systems.elastic.example.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

public class ElasticSearchResponseDataFactoryTest {

	private static final String AGGREGATIONS_GENRES = "{" + 
			"        \"genres\" : {" + 
			"            \"doc_count_error_upper_bound\": 0, " + 
			"            \"sum_other_doc_count\": 0, " + 
			"            \"buckets\" : [ " + 
			"                {" + 
			"                    \"key\" : \"electronic\"," + 
			"                    \"doc_count\" : 6" + 
			"                }," + 
			"                {" + 
			"                    \"key\" : \"rock\"," + 
			"                    \"doc_count\" : 3" + 
			"                }," + 
			"                {" + 
			"                    \"key\" : \"jazz\"," + 
			"                    \"doc_count\" : 2" + 
			"                }" + 
			"            ]" + 
			"        }" + 
			"}";
	
	private ElasticSearchResponseDataFactory elasticSearchResponseDataFactory;
	
	@Before
	public void setUp() {
		elasticSearchResponseDataFactory = new ElasticSearchResponseDataFactory();
	}
	
	@Test
	public void getTotalHits_when_json_have_total_hits_should_return_the_value_of_total_hits() throws JsonProcessingException, IOException {
	    final JsonNode root = this.createJsonNode("{\"hits\":{\"total\":{\"value\":27}}}");
		assertEquals("27", elasticSearchResponseDataFactory.getTotalHits(root));
	}
	
	@Test
	public void getAggregations_when_json_have_aggregations_should_return_aggregations() throws JsonProcessingException, IOException {
		final JsonNode expected = this.createJsonNode("{\"max_price\": {\"value\": 200.0}}");
		final JsonNode root = this.createJsonNode("{\"aggregations\": {\"max_price\": {\"value\": 200.0}}}");
		
		final JsonNode actual = elasticSearchResponseDataFactory.getAggregations(root);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getBuckets_when_json_have_buckets_with_name_should_return_buckets() throws JsonProcessingException, IOException {
		final JsonNode expected = this.createJsonNode("[" + 
				"{\"key\" : \"electronic\",\"doc_count\" : 6}," + 
				"{\"key\" : \"rock\",\"doc_count\" : 3}," + 
				"{\"key\" : \"jazz\", \"doc_count\" : 2}"+ 
				"]");
		final JsonNode aggregations = this.createJsonNode(AGGREGATIONS_GENRES);
		final JsonNode actual = elasticSearchResponseDataFactory.getBuckets(aggregations, "genres");
		assertEquals(expected, actual);
	}
	
	@Test
	public void getDateAggregation_when_json_not_have_buckets_with_same_name_should_return_null() throws JsonProcessingException, IOException {
		final JsonNode aggregations = this.createJsonNode("{" + 
				"    \"min\" : {" + 
				"      \"value\" : 1.5541107E12," + 
				"      \"value_as_string\" : \"2019/04/01 09:25:00\"" + 
				"    }" + 
				"  }");
		
		assertNull(elasticSearchResponseDataFactory.getDateAggregation(aggregations, "maxDate"));
	}
	
	@Test
	public void getDateAggregation_when_json_not_have_aggregations_with_value_as_string_should_return_null() throws JsonProcessingException, IOException {
		final JsonNode aggregations = this.createJsonNode("{" + 
				"    \"min\" : {" + 
				"      \"value\" : 1.5541107E12" + 
				"    }" +
				"  }");
		
		assertNull(elasticSearchResponseDataFactory.getDateAggregation(aggregations, "min"));
	}
	
	@Test
	public void getDateAggregation_when_json_have_aggregations_with_value_as_string_should_return_value_as_string() throws JsonProcessingException, IOException {
		final JsonNode aggregations = this.createJsonNode("{" + 
				"    \"max\" : {" + 
				"      \"value\" : 1.588680323E12," + 
				"      \"value_as_string\" : \"2020/05/05 12:05:23\"" + 
				"    }" + 
				"  }");
		
		final String actual = elasticSearchResponseDataFactory.getDateAggregation(aggregations, "max");
		assertEquals("2020/05/05 12:05:23", actual);
	}
	
	private JsonNode createJsonNode(final String json) throws JsonProcessingException, IOException {
	    final ObjectMapper mapper = new ObjectMapper();
	    return mapper.readTree(json);
	}
}
