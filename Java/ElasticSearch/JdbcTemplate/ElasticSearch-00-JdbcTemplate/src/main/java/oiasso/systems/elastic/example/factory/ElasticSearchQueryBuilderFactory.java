package oiasso.systems.elastic.example.factory;

import org.springframework.stereotype.Component;

import oiasso.systems.elastic.example.constant.BillingFields;

@Component
public class ElasticSearchQueryBuilderFactory {

	protected static final String QUERY_GET_SPOTS = "{" + 
			"\"size\": 0, " + 
			"  \"aggs\":{" + 
			"    \"" + BillingFields.SPOT_ID + "\":{" + 
			"      \"terms\": {" + 
			"        \"field\": \"" + BillingFields.SPOT_ID + "\", \"size\": 5000" + 
			"      }," + 
			"      \"aggs\": {" + 
			"        \"" + BillingFields.SPOT_NAME + "\": {" + 
			"          \"terms\": {" + 
			"            \"field\": \"" + BillingFields.SPOT_NAME + "\""	+ 
			"          }," + 
			"          \"aggs\": {" + 
			"            \"max\":{" + 
			"              \"max\": {" + 
			"                \"field\": \"" + BillingFields.DATE_START + "\"" + 
			"              }" + 
			"            }," + 
			"            \"spot_name_sort\": {" + 
			"              \"bucket_sort\": {" + 
			"                \"sort\": [" + 
			"                  {\"max\": {\"order\": \"desc\"}}" + 
			"                ]," + 
			"                \"size\": 1" + 
			"              }" + 
			"            }               " + 
			"          }" + 
			"        }" + 
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

	protected static final String QUERY_GET_DEVICES = "{" + 
			"\"size\": 0, " + 
			"  \"query\": {" + 
			"    \"bool\": {" + 
			"      \"filter\": { \"match\": {\"" + BillingFields.SPOT_ID + "\" : %d } }" + 
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

	protected static final String QUERY_GET_DATE_RANGES = "{" + 
			"\"size\": 0, " + 
			"  \"aggs\":{" + 
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

	public String createSpotsQuery() {
		return ElasticSearchQueryBuilderFactory.QUERY_GET_SPOTS;
	}

	public String createDevicesQuery(final Long spotId) {
		return String.format(ElasticSearchQueryBuilderFactory.QUERY_GET_DEVICES,spotId);
	}

	public String createDateRangesQuery() {
		return ElasticSearchQueryBuilderFactory.QUERY_GET_DATE_RANGES;
	}

}
