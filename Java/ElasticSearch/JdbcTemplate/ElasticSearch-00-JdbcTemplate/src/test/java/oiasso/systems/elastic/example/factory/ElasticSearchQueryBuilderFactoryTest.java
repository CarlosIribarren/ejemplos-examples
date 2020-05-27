package oiasso.systems.elastic.example.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import oiasso.systems.elastic.example.constant.BillingFields;

public class ElasticSearchQueryBuilderFactoryTest {

	protected static final String RESULT_QUERY_GET_DEVICES = "{" + 
			"\"size\": 0, " + 
			"  \"query\": {" + 
			"    \"bool\": {" + 
			"      \"filter\": { \"match\": {\"" + BillingFields.SPOT_ID + "\" : 741 } }" + 
			"    }" + 
			"  },  " + 
			"  \"aggs\":{" + 
			"    \"" + BillingFields.DEVICE_NAME + "\":{" + 
			"      \"terms\": {" + 
			"        \"field\": \"" + BillingFields.DEVICE_NAME + "\" , \"size\": 5000" + 
			"      }" + 
			"    }," + 
			"    \"min\":{" + 
			"      \"min\": {" + 
			"        \"field\": \"" + BillingFields.DATE_START + "\"" + 
			"      }" + 
			"    }," + 
			"    \"max\":{" + 
			"      \"max\": {" + 
			"        \"field\": \"" + BillingFields.DATE_END + "\"" + 
			"      }" + 
			"    }" + 
			"  }" + 
			"}";
	
	private ElasticSearchQueryBuilderFactory elasticSearchQueryBuilderFactory;
	
	@Before
	public void setUp() {
		elasticSearchQueryBuilderFactory = new ElasticSearchQueryBuilderFactory();
	}
	
	@Test
	public void createSpotsQuery_should_return_spots_query() {
		assertEquals(ElasticSearchQueryBuilderFactory.QUERY_GET_SPOTS, elasticSearchQueryBuilderFactory.createSpotsQuery());
	}
	
	@Test
	public void createDevicesQuery_should_return_devices_query_with_spot_id() {
		assertEquals(RESULT_QUERY_GET_DEVICES, elasticSearchQueryBuilderFactory.createDevicesQuery(741l));
	}
	
	@Test
	public void createDateRangesQuery_should_return_data_ranges_query() {
		assertEquals(ElasticSearchQueryBuilderFactory.QUERY_GET_DATE_RANGES, elasticSearchQueryBuilderFactory.createDateRangesQuery());
	}
	
}
