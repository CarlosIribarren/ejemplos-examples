package oiasso.systems.elastic.example.factory;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oiasso.systems.elastic.example.constant.BillingFields;
import oiasso.systems.elastic.example.constant.ElasticSearchFields;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.ValueText;

@Component
public class ElasticSearchResponseFactory {
	
	private final ElasticSearchResponseDataFactory dataFactory;
	
	@Autowired
	public ElasticSearchResponseFactory(final ElasticSearchResponseDataFactory dataFactory) {
		super();
		this.dataFactory = dataFactory;
	}

	public String getTotalHits(final JsonNode root) {
		return dataFactory.getTotalHits(root);
	}
	
	public List<ValueText> getSpotList(final JsonNode root) {
		
		final List<ValueText> spotList = new ArrayList<>();
		
		final JsonNode aggregations = dataFactory.getAggregations(root);
		
		final JsonNode buckets = dataFactory.getBuckets(aggregations, BillingFields.SPOT_ID);
		if (buckets != null && buckets.isArray()) {
			for (final JsonNode bucket : buckets) {

				// Get spot id
				final String spotId = bucket.get(ElasticSearchFields.KEY).asText();

				// Get spot name list
				final JsonNode nameList = bucket.path(BillingFields.SPOT_NAME).path(ElasticSearchFields.BUCKETS);

				// Get only firts name, that have date_start max
				final String spotName = nameList.get(0).get(ElasticSearchFields.KEY).getTextValue();

				spotList.add(new ValueText(spotId, spotName));
			}
		}
		return spotList;
	}
	
	
	public List<ValueText> getDevices(final JsonNode root){
		final List<ValueText> deviceList = new ArrayList<>();
		
		final JsonNode aggregations = dataFactory.getAggregations(root);

		// Device list
		final JsonNode buckets = dataFactory.getBuckets(aggregations, BillingFields.DEVICE_NAME);
		if (buckets != null && buckets.isArray()) {
			for (final JsonNode bucket : buckets) {

				// Get device name
				final String deviceName = bucket.get(ElasticSearchFields.KEY).asText();
				
				deviceList.add(new ValueText(deviceName, deviceName));
			}
		}
		return deviceList;
	}
	
	public BillingReportFilterDateRangesDto getDateRanges(final JsonNode response) {
		final BillingReportFilterDateRangesDto ranges = new BillingReportFilterDateRangesDto();
		final JsonNode aggregations = dataFactory.getAggregations(response);
		ranges.setMin(dataFactory.getDateAggregation(aggregations, ElasticSearchFields.MIN));
		ranges.setMax(dataFactory.getDateAggregation(aggregations, ElasticSearchFields.MAX));
		return ranges;
	}
	
}
