package oiasso.systems.elastic.example.facade.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.factory.ElasticSearchQueryBuilderFactory;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterValueListDto;
import oiasso.systems.elastic.example.model.dto.ValueText;
import oiasso.systems.elastic.example.service.ElasticSearchRequestService;
import oiasso.systems.elastic.example.service.ElasticSearchResponseService;

public class BillingReportFilterFacadeImplTest {

	private static final String VALUE_DATE_MIN = "2020/02/25 00:54:00";
	
	private static final String VALUE_DATE_MAX = "2020/04/30 10:34:53";
	
	private static final String VALUE_SPOT_ID = "271";
	
	private static final String VALUE_SPOT_NAME = "Nike";
	
	private static final String VALUE_DEVICE_NAME = "ctsdem01";
	
	private static final String MOCK_QUERY = "mockQuery";
	
	@InjectMocks
	private BillingReportFilterFacadeImpl billingReportFilterFacadeImpl; 
	
	@Mock
	private ElasticSearchRequestService requestService;
	
	@Mock
	private ElasticSearchQueryBuilderFactory queryBuilderFactory;
	
	@Mock
	private ElasticSearchResponseService responseService;
	
	@Before
	public void setUp() throws ElasticSearchConsultException {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getSpots_verify_all_methods_are_calles_one_time() throws ElasticSearchConsultException {
		billingReportFilterFacadeImpl.getSpots();
		
		verify(queryBuilderFactory, times(1)).createSpotsQuery();
		verify(requestService, times(1)).executeSearchRequest(anyString());
		verify(responseService, times(1)).isEmpty(any(JsonNode.class));
	}
	
	@Test
	public void getSpots_when_the_answer_is_empty_should_return_empty_list_and_date_ranges_null() throws ElasticSearchConsultException {
		when(responseService.isEmpty(null)).thenReturn(true);
		
		final BillingReportFilterValueListDto actual = billingReportFilterFacadeImpl.getSpots();
		
		Assert.assertTrue(actual.getList().isEmpty());
		Assert.assertNull(actual.getDates().getMin());
		Assert.assertNull(actual.getDates().getMax());
	}
	
	@Test
	public void getSpots_when_the_answer_is_not_empty_should_return_spot_list_and_date_ranges() throws ElasticSearchConsultException, JsonProcessingException, IOException {
		when(queryBuilderFactory.createSpotsQuery()).thenReturn(MOCK_QUERY);
		when(requestService.executeSearchRequest(anyString())).thenReturn(createEmptyJsonNode());
		when(responseService.isEmpty(any(JsonNode.class))).thenReturn(false);
		final BillingReportFilterValueListDto mockResult = new BillingReportFilterValueListDto();
		mockResult.getList().add(new ValueText(VALUE_SPOT_ID, VALUE_SPOT_NAME));
		mockResult.setDates(new BillingReportFilterDateRangesDto(VALUE_DATE_MIN, VALUE_DATE_MAX ));
		when(responseService.getSpotsResponse(any(JsonNode.class))).thenReturn(mockResult);
		
		final BillingReportFilterValueListDto actual = billingReportFilterFacadeImpl.getSpots();
		
		Assert.assertEquals(VALUE_SPOT_ID, actual.getList().get(0).getValue());
		Assert.assertEquals(VALUE_SPOT_NAME, actual.getList().get(0).getText());
		Assert.assertEquals(VALUE_DATE_MIN, actual.getDates().getMin());
		Assert.assertEquals(VALUE_DATE_MAX, actual.getDates().getMax());
	}
	
	@Test
	public void getDevices_verify_all_methods_are_calles_one_time() throws ElasticSearchConsultException {
		billingReportFilterFacadeImpl.getDevices(anyLong());
		
		verify(queryBuilderFactory, times(1)).createDevicesQuery(anyLong());
		verify(requestService, times(1)).executeSearchRequest(anyString());
		verify(responseService, times(1)).isEmpty(any(JsonNode.class));
	}
	
	@Test
	public void getDevices_when_the_answer_is_empty_should_return_empty_list_and_date_ranges_null() throws ElasticSearchConsultException {
		when(responseService.isEmpty(null)).thenReturn(true);
		
		final BillingReportFilterValueListDto actual = billingReportFilterFacadeImpl.getDevices(741l);
		
		assertTrue(actual.getList().isEmpty());
		assertNull(actual.getDates().getMin());
		assertNull(actual.getDates().getMax());
	}
	
	@Test
	public void getDevices_when_the_answer_is_not_empty_should_return_device_list_and_date_ranges() throws ElasticSearchConsultException, JsonProcessingException, IOException {
		when(queryBuilderFactory.createDevicesQuery(anyLong())).thenReturn(MOCK_QUERY);
		when(requestService.executeSearchRequest(anyString())).thenReturn(createEmptyJsonNode());
		when(responseService.isEmpty(any(JsonNode.class))).thenReturn(false);
		final BillingReportFilterValueListDto mockResult = new BillingReportFilterValueListDto();
		mockResult.getList().add(new ValueText(VALUE_DEVICE_NAME, VALUE_DEVICE_NAME));
		mockResult.setDates(new BillingReportFilterDateRangesDto(VALUE_DATE_MIN, VALUE_DATE_MAX));
		when(responseService.getDevicesResponse(any(JsonNode.class))).thenReturn(mockResult);
		
		final BillingReportFilterValueListDto actual = billingReportFilterFacadeImpl.getDevices(anyLong());
		
		assertEquals(VALUE_DEVICE_NAME, actual.getList().get(0).getValue());
		assertEquals(VALUE_DEVICE_NAME, actual.getList().get(0).getText());
		assertEquals(VALUE_DATE_MIN, actual.getDates().getMin());
		assertEquals(VALUE_DATE_MAX, actual.getDates().getMax());
	}
	
	@Test
	public void getDateRanges_verify_all_methods_are_calles_one_time() throws ElasticSearchConsultException {
		billingReportFilterFacadeImpl.getDateRanges();
		
		verify(queryBuilderFactory, times(1)).createDateRangesQuery();
		verify(requestService, times(1)).executeSearchRequest(anyString());
		verify(responseService, times(1)).isEmpty(any(JsonNode.class));
	}
	
	@Test
	public void getDateRanges_when_the_answer_is_empty_should_return_date_ranges_null() throws ElasticSearchConsultException {
		when(responseService.isEmpty(null)).thenReturn(true);
		
		final BillingReportFilterDateRangesDto actual = billingReportFilterFacadeImpl.getDateRanges();
		
		assertNull(actual.getMin());
		assertNull(actual.getMax());
	}
	
	@Test
	public void getDateRanges_when_the_answer_is_not_empty_should_return_date_ranges() throws ElasticSearchConsultException, JsonProcessingException, IOException {
		when(queryBuilderFactory.createDateRangesQuery()).thenReturn(MOCK_QUERY);
		when(requestService.executeSearchRequest(anyString())).thenReturn(createEmptyJsonNode());
		when(responseService.isEmpty(any(JsonNode.class))).thenReturn(false);
		final BillingReportFilterDateRangesDto mockResult = new BillingReportFilterDateRangesDto(VALUE_DATE_MIN, VALUE_DATE_MAX);
		when(responseService.getDateRanges(any(JsonNode.class))).thenReturn(mockResult);
		
		final BillingReportFilterDateRangesDto actual = billingReportFilterFacadeImpl.getDateRanges();
		
		assertEquals(VALUE_DATE_MIN, actual.getMin());
		assertEquals(VALUE_DATE_MAX, actual.getMax());
	}
	
	private JsonNode createEmptyJsonNode() throws JsonProcessingException, IOException {
	    final ObjectMapper mapper = new ObjectMapper();
	    return mapper.readTree("{}");
	}
	
}
