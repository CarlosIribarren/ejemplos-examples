package oiasso.systems.elastic.example.factory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import oiasso.systems.elastic.example.constant.BillingFields;
import oiasso.systems.elastic.example.constant.ElasticSearchFields;
import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.ValueText;

public class ElasticSearchResponseFactoryTest {

	private static final String VALUE_DATE_MIN = "2020/02/25 00:54:00";
	
	private static final String VALUE_DATE_MAX = "2020/04/30 10:34:53";
	
	private static final String VALUE_DEVICE_NAME_1 = "ctsdem01";
	
	private static final String VALUE_DEVICE_NAME_2 = "ctsdem02";
	
	private static final String VALUE_DEVICE_NAME_3 = "ctsdem03";
	
	private static final String VALUE_SPOT_ID_1 = "741";
	
	private static final String VALUE_SPOT_NAME_1 = "Nike";
	
	private static final String VALUE_SPOT_ID_2 = "782";
	
	private static final String VALUE_SPOT_NAME_2 = "Audi";
	
	private static final String SPOT_LIST_BUCKETS = "[" + 
			"        {" + 
			"          \"key\" : " + VALUE_SPOT_ID_1 + ", \"doc_count\" : 2667," + 
			"          \"" + BillingFields.SPOT_NAME + "\" : {" + 
			"            \"doc_count_error_upper_bound\" : 0, \"sum_other_doc_count\" : 0," + 
			"            \"buckets\" : [" + 
			"              {" + 
			"                \"key\" : \"" + VALUE_SPOT_NAME_1 + "\", \"doc_count\" : 2667," + 
			"                \"maxDate\" : { \"value\" : 1.588687817E12, \"value_as_string\" : \"2020/05/05 14:10:17\" }" + 
			"              }" + 
			"            ]" + 
			"          }" + 
			"        }," + 
			"        {" + 
			"          \"key\" : " + VALUE_SPOT_ID_2 + ", \"doc_count\" : 1824," + 
			"          \"" + BillingFields.SPOT_NAME + "\" : {" + 
			"            \"doc_count_error_upper_bound\" : 0, \"sum_other_doc_count\" : 0," + 
			"            \"buckets\" : [" + 
			"              {" + 
			"                \"key\" : \"" + VALUE_SPOT_NAME_2 + "\", \"doc_count\" : 1824," + 
			"                \"maxDate\" : { \"value\" : 1.588687807E12, \"value_as_string\" : \"2020/05/05 14:10:07\" }" + 
			"              }" + 
			"            ]" + 
			"          }" + 
			"        }"	+ 
			"     ]"; 
			
	private static final String SPOT_LIST_AGGREGATIONS = "{" + 
			"    \"minimo\" : {" + 
			"      \"value\" : 1.5541107E12," + 
			"      \"value_as_string\" : \"2019/04/01 09:25:00\"" + 
			"    }," + 
			"    \"" + BillingFields.SPOT_ID + "\" : {" + 
			"      \"doc_count_error_upper_bound\" : 0," + 
			"      \"sum_other_doc_count\" : 0," + 
			"      \"buckets\" : [" + SPOT_LIST_BUCKETS + "]"	+
			"     }" + 
			"  }";	
	
	private static final String SPOT_LIST_ROOT = "{\"aggregations\" : " + SPOT_LIST_AGGREGATIONS + "}";
	
	private static final String DEVICE_LIST_BUCKETS = "[" + 
	"        {" + 
	"          \"key\" : \"" + VALUE_DEVICE_NAME_2 + "\"," + 
	"          \"doc_count\" : 2681" + 
	"        }," + 
	"        {" + 
	"          \"key\" : \"" + VALUE_DEVICE_NAME_1 + "\"," + 
	"          \"doc_count\" : 94" + 
	"        }," + 
	"        {" + 
	"          \"key\" : \"" + VALUE_DEVICE_NAME_3 + "\"," + 
	"          \"doc_count\" : 7" + 
	"        }" + 
	"      ]";
	
	private static final String DEVICE_LIST_AGGREGATIONS = "{" +
	"  \"aggregations\" : {" + 
	"    \"" +  BillingFields.DEVICE_NAME + "\" : {" + 
	"      \"doc_count_error_upper_bound\" : 0," + 
	"      \"sum_other_doc_count\" : 0," + 
	"      \"buckets\" : " + DEVICE_LIST_BUCKETS +
	"    }" + 
	"  }" +
	"}";
	
	private static final String DEVICE_LIST_ROOT = "{\"aggregations\" : " + DEVICE_LIST_AGGREGATIONS + "}";
	
	private static final String DATE_RANGES_AGGREGATIONS = "{" +
	"    \"min\" : {" + 
	"      \"value\" : 1.588242893E12," + 
	"      \"value_as_string\" : \"" + VALUE_DATE_MIN  + "\"" + 
	"    }," + 
	"    \"max\" : {" + 
	"      \"value\" : 1.588696209E12," + 
	"      \"value_as_string\" : \"" + VALUE_DATE_MAX  + "\"" + 
	"    }" +
	"}"; 
	
	private static final String DATE_RANGES_ROOT = "{\"aggregations\" : " + DATE_RANGES_AGGREGATIONS + "}";
	
	@InjectMocks
	private ElasticSearchResponseFactory elasticSearchResponseFactory;
	
	@Mock
	private ElasticSearchResponseDataFactory dataFactory;
	
	@Before
	public void setUp() throws ElasticSearchConsultException {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getTotalHits_verify_getTotalHits_of_data_factory_is_called() {
		elasticSearchResponseFactory.getTotalHits(any(JsonNode.class));
		verify(dataFactory, times(1)).getTotalHits(any(JsonNode.class));
	}
	
	@Test
	public void getSpotList_verify_all_methods_are_calles_one_time() {
		elasticSearchResponseFactory.getSpotList(any(JsonNode.class));
		
		verify(dataFactory, times(1)).getAggregations(any(JsonNode.class));
		verify(dataFactory, times(1)).getBuckets(any(JsonNode.class),eq(BillingFields.SPOT_ID));
	}	

	@Test
	public void getSpotList_when_json_is_empty_should_return_empty_list() throws JsonProcessingException, IOException {
		final JsonNode emptyData = this.createJsonNode("{}");
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(emptyData);
		when(dataFactory.getBuckets(any(JsonNode.class), eq(BillingFields.SPOT_ID))).thenReturn(emptyData);
		
		final List<ValueText> expected = new ArrayList<>();
		
		final List<ValueText> actual = elasticSearchResponseFactory.getSpotList(emptyData);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSpotList_when_json_have_aggregations_of_spots_should_return_spot_list() throws JsonProcessingException, IOException {
		final JsonNode aggregations = this.createJsonNode(SPOT_LIST_AGGREGATIONS);
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(aggregations);
		final JsonNode buckets = this.createJsonNode(SPOT_LIST_BUCKETS);
		when(dataFactory.getBuckets(any(JsonNode.class), eq(BillingFields.SPOT_ID))).thenReturn(buckets);
		
		final List<ValueText> actual = elasticSearchResponseFactory.getSpotList(createJsonNode(SPOT_LIST_ROOT));
		
		assertEquals(VALUE_SPOT_ID_1, actual.get(0).getValue());
		assertEquals(VALUE_SPOT_NAME_1, actual.get(0).getText());
		assertEquals(VALUE_SPOT_ID_2, actual.get(1).getValue());
		assertEquals(VALUE_SPOT_NAME_2, actual.get(1).getText());
	}	
	
	@Test
	public void getDevices_verify_all_methods_are_calles_one_time() {
		elasticSearchResponseFactory.getDevices(any(JsonNode.class));
		
		verify(dataFactory, times(1)).getAggregations(any(JsonNode.class));
		verify(dataFactory, times(1)).getBuckets(any(JsonNode.class),eq(BillingFields.DEVICE_NAME));
	}
	
	@Test
	public void getDevices_when_json_is_empty_should_return_empty_list() throws JsonProcessingException, IOException {
		final JsonNode emptyData = this.createJsonNode("{}");
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(emptyData);
		when(dataFactory.getBuckets(any(JsonNode.class), eq(BillingFields.DEVICE_NAME))).thenReturn(emptyData);
		
		final List<ValueText> expected = new ArrayList<>();
		
		final List<ValueText> actual = elasticSearchResponseFactory.getDevices(emptyData);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getDevices_when_json_have_aggregations_of_devices_should_return_device_list() throws JsonProcessingException, IOException {
		final JsonNode aggregations = this.createJsonNode(DEVICE_LIST_AGGREGATIONS);
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(aggregations);
		final JsonNode buckets = this.createJsonNode(DEVICE_LIST_BUCKETS);
		when(dataFactory.getBuckets(any(JsonNode.class), eq(BillingFields.DEVICE_NAME))).thenReturn(buckets);
		
		final List<ValueText> actual = elasticSearchResponseFactory.getDevices(createJsonNode(DEVICE_LIST_ROOT));
		
		assertEquals(VALUE_DEVICE_NAME_2, actual.get(0).getValue());
		assertEquals(VALUE_DEVICE_NAME_2, actual.get(0).getText());
		assertEquals(VALUE_DEVICE_NAME_1, actual.get(1).getValue());
		assertEquals(VALUE_DEVICE_NAME_1, actual.get(1).getText());
		assertEquals(VALUE_DEVICE_NAME_3, actual.get(2).getValue());
		assertEquals(VALUE_DEVICE_NAME_3, actual.get(2).getText());
	}
	
	
	@Test
	public void getDateRanges_verify_all_methods_are_calles_one_time() {
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(null);
		
		elasticSearchResponseFactory.getDateRanges(any(JsonNode.class));
		
		verify(dataFactory, times(1)).getAggregations(any(JsonNode.class));
		verify(dataFactory, times(1)).getDateAggregation(null,ElasticSearchFields.MIN);
		verify(dataFactory, times(1)).getDateAggregation(null,ElasticSearchFields.MAX);
	}
	
	@Test
	public void getDateRanges_when_data_ranges_are_null_should_return_data_ranges_null() throws JsonProcessingException, IOException {
		final JsonNode emptyData = this.createJsonNode("{}");
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(emptyData);
		when(dataFactory.getDateAggregation(any(JsonNode.class), eq(ElasticSearchFields.MIN))).thenReturn(null);
		when(dataFactory.getDateAggregation(any(JsonNode.class), eq(ElasticSearchFields.MAX))).thenReturn(null);
		
		final BillingReportFilterDateRangesDto expected = new BillingReportFilterDateRangesDto(null,null);
		
		final BillingReportFilterDateRangesDto actual =elasticSearchResponseFactory.getDateRanges(emptyData);
		
		assertEquals(expected.getMin(), actual.getMin());
		assertEquals(expected.getMax(), actual.getMax());
	}
	
	@Test
	public void getDateRanges_when_data_ranges_have_values_should_return_data_ranges() throws JsonProcessingException, IOException {
		final JsonNode aggregations = this.createJsonNode(DATE_RANGES_AGGREGATIONS);
		when(dataFactory.getAggregations(any(JsonNode.class))).thenReturn(aggregations);
		when(dataFactory.getDateAggregation(any(JsonNode.class), eq(ElasticSearchFields.MIN))).thenReturn(VALUE_DATE_MIN);
		when(dataFactory.getDateAggregation(any(JsonNode.class), eq(ElasticSearchFields.MAX))).thenReturn(VALUE_DATE_MAX);
		
		final BillingReportFilterDateRangesDto actual =elasticSearchResponseFactory.getDateRanges(createJsonNode(DATE_RANGES_ROOT));
		
		assertEquals(VALUE_DATE_MIN, actual.getMin());
		assertEquals(VALUE_DATE_MAX, actual.getMax());
	}
	
	private JsonNode createJsonNode(final String json) throws JsonProcessingException, IOException {
	    final ObjectMapper mapper = new ObjectMapper();
	    return mapper.readTree(json);
	}
	
}
