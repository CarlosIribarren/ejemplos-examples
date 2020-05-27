package oiasso.systems.elastic.example.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.factory.ElasticSearchResponseFactory;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterValueListDto;
import oiasso.systems.elastic.example.model.dto.ValueText;
import oiasso.systems.elastic.example.util.ListOfValueTextUtils;

public class ElasticSearchResponseServiceImplTest {

	private static final String VALUE_DATE_MIN = "2020/02/25 00:54:00";
	
	private static final String VALUE_DATE_MAX = "2020/04/30 10:34:53";
	
	private static final String VALUE_SPOT_ID = "271";
	
	private static final String VALUE_SPOT_NAME = "Nike";
	
	private static final String VALUE_DEVICE_NAME = "ctsdem01";
	
	@InjectMocks
	private ElasticSearchResponseServiceImpl elasticSearchResponseServiceImpl;
	
	@Mock
	private ElasticSearchResponseFactory responseFactory;
	
	@Mock
	private ListOfValueTextUtils listOfValueTextUtils;
	
	@Before
	public void setUp() throws ElasticSearchConsultException {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void isEmpty_when_json_is_null_should_return_null() throws JsonProcessingException, IOException {
		assertFalse(elasticSearchResponseServiceImpl.isEmpty(null));
	}
	
	@Test
	public void isEmpty_when_json_have_total_hits_0_should_return_true() throws JsonProcessingException, IOException {
		when(responseFactory.getTotalHits(any(JsonNode.class))).thenReturn("0");
		assertTrue(elasticSearchResponseServiceImpl.isEmpty(createEmptyJsonNode()));
	}
	
	@Test
	public void isEmpty_when_json_have_total_hits_different_0_should_return_false() throws JsonProcessingException, IOException {
		when(responseFactory.getTotalHits(any(JsonNode.class))).thenReturn("1");
		assertFalse(elasticSearchResponseServiceImpl.isEmpty(createEmptyJsonNode()));
	}
	
	@Test
	public void getSpotsResponse_when_json_have_spot_list_and_data_ranges_should_return_spot_list_and_data_ranges() throws JsonProcessingException, IOException {
		final List<ValueText> mockSpotList = new ArrayList<>();
		mockSpotList.add(new ValueText(VALUE_SPOT_ID, VALUE_SPOT_NAME));
		when(responseFactory.getSpotList(any(JsonNode.class))).thenReturn(mockSpotList);
		final BillingReportFilterDateRangesDto mockDateRanges = new BillingReportFilterDateRangesDto(VALUE_DATE_MIN, VALUE_DATE_MAX);
		when(responseFactory.getDateRanges(any(JsonNode.class))).thenReturn(mockDateRanges);
		doNothing().when(listOfValueTextUtils).sortByText(Matchers.<List<ValueText>> any());
		
		final BillingReportFilterValueListDto actual = elasticSearchResponseServiceImpl.getSpotsResponse(createEmptyJsonNode());
		
		assertEquals(VALUE_SPOT_ID, actual.getList().get(0).getValue());
		assertEquals(VALUE_SPOT_NAME, actual.getList().get(0).getText());
		assertEquals(VALUE_DATE_MIN, actual.getDates().getMin());
		assertEquals(VALUE_DATE_MAX, actual.getDates().getMax());
	}
	
	@Test
	public void getDevicesResponse_when_json_have_device_list_and_data_ranges_should_return_device_list_and_data_ranges() throws JsonProcessingException, IOException {
		final List<ValueText> mockDevicesList = new ArrayList<>();
		mockDevicesList.add(new ValueText(VALUE_DEVICE_NAME, VALUE_DEVICE_NAME));
		when(responseFactory.getDevices(any(JsonNode.class))).thenReturn(mockDevicesList);
		final BillingReportFilterDateRangesDto mockDateRanges = new BillingReportFilterDateRangesDto(VALUE_DATE_MIN, VALUE_DATE_MAX);
		when(responseFactory.getDateRanges(any(JsonNode.class))).thenReturn(mockDateRanges);
		doNothing().when(listOfValueTextUtils).sortByText(Matchers.<List<ValueText>> any());
		
		final BillingReportFilterValueListDto actual = elasticSearchResponseServiceImpl.getDevicesResponse(createEmptyJsonNode());
		
		assertEquals(VALUE_DEVICE_NAME, actual.getList().get(0).getValue());
		assertEquals(VALUE_DEVICE_NAME, actual.getList().get(0).getText());
		assertEquals(VALUE_DATE_MIN, actual.getDates().getMin());
		assertEquals(VALUE_DATE_MAX, actual.getDates().getMax());
	}
	
	@Test
	public void getDateRanges_when_json_have_data_ranges_should_return_data_ranges() throws JsonProcessingException, IOException {
		final BillingReportFilterDateRangesDto mockDateRanges = new BillingReportFilterDateRangesDto(VALUE_DATE_MIN, VALUE_DATE_MAX);
		when(responseFactory.getDateRanges(any(JsonNode.class))).thenReturn(mockDateRanges);
		
		final BillingReportFilterDateRangesDto actual = elasticSearchResponseServiceImpl.getDateRanges(createEmptyJsonNode());
		
		assertEquals(VALUE_DATE_MIN, actual.getMin());
		assertEquals(VALUE_DATE_MAX, actual.getMax());
	}
	
	private JsonNode createEmptyJsonNode() throws JsonProcessingException, IOException {
	    final ObjectMapper mapper = new ObjectMapper();
	    return mapper.readTree("{}");
	}
	
}
