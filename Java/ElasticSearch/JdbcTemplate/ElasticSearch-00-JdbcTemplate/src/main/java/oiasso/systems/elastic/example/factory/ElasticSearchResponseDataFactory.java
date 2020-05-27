package oiasso.systems.elastic.example.factory;

import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Component;

import oiasso.systems.elastic.example.constant.ElasticSearchFields;

@Component
public class ElasticSearchResponseDataFactory {

	public String getTotalHits(final JsonNode root) {
		return root.path(ElasticSearchFields.HITS).path(ElasticSearchFields.TOTAL).path(ElasticSearchFields.VALUE).asText();
	}
	
	public JsonNode getAggregations(final JsonNode root) {
		return root.path(ElasticSearchFields.AGGREGATIONS);
	}
	
	public JsonNode getBuckets(final JsonNode aggregations, final String bucketName) {
		return aggregations.path(bucketName).path(ElasticSearchFields.BUCKETS);
	}
	
	public String getDateAggregation(final JsonNode aggregations, final String aggregationName) {
		final JsonNode dateObject = aggregations.get(aggregationName);
		if(dateObject == null) { return null;}

		final JsonNode dateFormatted = dateObject.get(ElasticSearchFields.VALUE_AS_STRING);
		if(dateFormatted == null) { return null; }

		return dateFormatted.asText();
	}
}
