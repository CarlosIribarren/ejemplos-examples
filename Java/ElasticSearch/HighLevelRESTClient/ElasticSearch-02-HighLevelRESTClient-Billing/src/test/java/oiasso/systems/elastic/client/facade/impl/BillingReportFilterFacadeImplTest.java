package oiasso.systems.elastic.client.facade.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.xcontent.ContextParser;
import org.elasticsearch.common.xcontent.DeprecationHandler;
import org.elasticsearch.common.xcontent.NamedXContentRegistry;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.adjacency.ParsedAdjacencyMatrix;
import org.elasticsearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.composite.ParsedComposite;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.ParsedFilter;
import org.elasticsearch.search.aggregations.bucket.filter.ParsedFilters;
import org.elasticsearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.global.ParsedGlobal;
import org.elasticsearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.ParsedAutoDateHistogram;
import org.elasticsearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
import org.elasticsearch.search.aggregations.bucket.histogram.ParsedHistogram;
import org.elasticsearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.missing.ParsedMissing;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedReverseNested;
import org.elasticsearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.range.ParsedBinaryRange;
import org.elasticsearch.search.aggregations.bucket.range.ParsedDateRange;
import org.elasticsearch.search.aggregations.bucket.range.ParsedGeoDistance;
import org.elasticsearch.search.aggregations.bucket.range.ParsedRange;
import org.elasticsearch.search.aggregations.bucket.range.RangeAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.sampler.InternalSampler;
import org.elasticsearch.search.aggregations.bucket.sampler.ParsedSampler;
import org.elasticsearch.search.aggregations.bucket.significant.ParsedSignificantLongTerms;
import org.elasticsearch.search.aggregations.bucket.significant.ParsedSignificantStringTerms;
import org.elasticsearch.search.aggregations.bucket.significant.SignificantLongTerms;
import org.elasticsearch.search.aggregations.bucket.significant.SignificantStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.DoubleTerms;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.GeoBoundsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentileRanks;
import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.elasticsearch.search.aggregations.metrics.InternalTDigestPercentileRanks;
import org.elasticsearch.search.aggregations.metrics.InternalTDigestPercentiles;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MinAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedAvg;
import org.elasticsearch.search.aggregations.metrics.ParsedCardinality;
import org.elasticsearch.search.aggregations.metrics.ParsedExtendedStats;
import org.elasticsearch.search.aggregations.metrics.ParsedGeoBounds;
import org.elasticsearch.search.aggregations.metrics.ParsedGeoCentroid;
import org.elasticsearch.search.aggregations.metrics.ParsedHDRPercentileRanks;
import org.elasticsearch.search.aggregations.metrics.ParsedHDRPercentiles;
import org.elasticsearch.search.aggregations.metrics.ParsedMax;
import org.elasticsearch.search.aggregations.metrics.ParsedMedianAbsoluteDeviation;
import org.elasticsearch.search.aggregations.metrics.ParsedMin;
import org.elasticsearch.search.aggregations.metrics.ParsedScriptedMetric;
import org.elasticsearch.search.aggregations.metrics.ParsedStats;
import org.elasticsearch.search.aggregations.metrics.ParsedSum;
import org.elasticsearch.search.aggregations.metrics.ParsedTDigestPercentileRanks;
import org.elasticsearch.search.aggregations.metrics.ParsedTDigestPercentiles;
import org.elasticsearch.search.aggregations.metrics.ParsedTopHits;
import org.elasticsearch.search.aggregations.metrics.ParsedValueCount;
import org.elasticsearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.StatsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.SumAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.TopHitsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ValueCountAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.InternalBucketMetricValue;
import org.elasticsearch.search.aggregations.pipeline.InternalSimpleValue;
import org.elasticsearch.search.aggregations.pipeline.ParsedBucketMetricValue;
import org.elasticsearch.search.aggregations.pipeline.ParsedDerivative;
import org.elasticsearch.search.aggregations.pipeline.ParsedExtendedStatsBucket;
import org.elasticsearch.search.aggregations.pipeline.ParsedPercentilesBucket;
import org.elasticsearch.search.aggregations.pipeline.ParsedSimpleValue;
import org.elasticsearch.search.aggregations.pipeline.ParsedStatsBucket;
import org.elasticsearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import oiasso.systems.elastic.client.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterValueListDto;
import oiasso.systems.elastic.client.service.impl.ElasticSearchServiceImpl;

public class BillingReportFilterFacadeImplTest {

	@InjectMocks
	private BillingReportFilterFacadeImpl billingReportFilterFacadeImpl;

	@Mock
	private ElasticSearchServiceImpl elasticSearchServiceImpl;

	@Before
	public void setUp() throws ElasticSearchConsultException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSpots() throws ElasticSearchConsultException {

		// Esta respuesta tiene los tipos añadidos en las agregaciones, por ejemplo, min#minDate, donde el formato es TIPO#NOMBRE.
		// Es muy importante escribir asi la respuesta, para que el metodo privado getDefaultNamedXContents() de esta clase, 
		// sepa de que tipo es y pueda hacer bien la tranformacion a un objeto SearchResponse. Si no se escribe el tipo, retorna null.
		// Para obtener los tipos de las agregaciones,... se puede ejecutar una consulta con el parametro "typed_keys" en alguna herramienta externa.
		// Ejemplo: "GET billing-*/_search?typed_keys" 
		String jsonResponse = "{" + 
				"  \"took\" : 25," + 
				"  \"timed_out\" : false," + 
				"  \"_shards\" : {" + 
				"    \"total\" : 1," + 
				"    \"successful\" : 1," + 
				"    \"skipped\" : 0," + 
				"    \"failed\" : 0" + 
				"  }," + 
				"  \"hits\" : {" + 
				"    \"total\" : {" + 
				"      \"value\" : 3," + 
				"      \"relation\" : \"eq\"" + 
				"    }," + 
				"    \"max_score\" : null," + 
				"    \"hits\" : [ ]" + 
				"  }," + 
				"  \"aggregations\" : {" + 
				"    \"min#minDate\" : {" + 
				"      \"value\" : 1.57966776E12," + 
				"      \"value_as_string\" : \"2020/01/22 04:36:00\"" + 
				"    }," + 
				"    \"lterms#spot_id\" : {" + 
				"      \"doc_count_error_upper_bound\" : 0," + 
				"      \"sum_other_doc_count\" : 0," + 
				"      \"buckets\" : [" + 
				"        {" + 
				"          \"key\" : 1," + 
				"          \"doc_count\" : 2," + 
				"          \"sterms#spot_name.keyword\" : {" + 
				"            \"doc_count_error_upper_bound\" : 0," + 
				"            \"sum_other_doc_count\" : 0," + 
				"            \"buckets\" : [" + 
				"              {" + 
				"                \"key\" : \"Nike\"," + 
				"                \"doc_count\" : 2" + 
				"              }" + 
				"            ]" + 
				"          }" + 
				"        }," + 
				"        {" + 
				"          \"key\" : 2," + 
				"          \"doc_count\" : 1," + 
				"          \"sterms#spot_name.keyword\" : {" + 
				"            \"doc_count_error_upper_bound\" : 0," + 
				"            \"sum_other_doc_count\" : 0," + 
				"            \"buckets\" : [" + 
				"              {" + 
				"                \"key\" : \"Coca Cola\"," + 
				"                \"doc_count\" : 1" + 
				"              }" + 
				"            ]" + 
				"          }" + 
				"        }" + 
				"      ]" + 
				"    }," + 
				"    \"max#maxDate\" : {" + 
				"      \"value\" : 1.629028981E12," + 
				"      \"value_as_string\" : \"2021/08/15 12:03:01\"" + 
				"    }" + 
				"  }" + 
				"}" + 
				"";

		SearchResponse searchResponseMock = this.getSearchResponseFromJson(jsonResponse);
		
		Mockito.when(
				elasticSearchServiceImpl.executeSearchRequest(any(SearchRequest.class), eq(RequestOptions.DEFAULT)))
				.thenReturn(searchResponseMock);

		BillingReportFilterValueListDto actual = billingReportFilterFacadeImpl.getSpots();
		
		Assert.assertEquals("1", actual.getList().get(0).getValue());
		Assert.assertEquals("Nike", actual.getList().get(0).getText());
		Assert.assertEquals("2", actual.getList().get(1).getValue());
		Assert.assertEquals("Coca Cola", actual.getList().get(1).getText());
		Assert.assertEquals("2020/01/22 04:36:00", actual.getDates().getMin());
		Assert.assertEquals("2021/08/15 12:03:01", actual.getDates().getMax());		
		
	}

	private SearchResponse getSearchResponseFromJson(String jsonResponse) {
		try {
			NamedXContentRegistry registry = new NamedXContentRegistry(this.getDefaultNamedXContents());
			XContentParser parser = JsonXContent.jsonXContent.createParser(registry,
					DeprecationHandler.THROW_UNSUPPORTED_OPERATION, jsonResponse);
			return SearchResponse.fromXContent(parser);
		} catch (Exception e) {
			System.out.println("exception " + e);
		}
		return null;
	}

	private List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {
		Map<String, ContextParser<Object, ? extends Aggregation>> map = new HashMap<>();
		map.put(CardinalityAggregationBuilder.NAME, (p, c) -> ParsedCardinality.fromXContent(p, (String) c));
		map.put(InternalHDRPercentiles.NAME, (p, c) -> ParsedHDRPercentiles.fromXContent(p, (String) c));
		map.put(InternalHDRPercentileRanks.NAME, (p, c) -> ParsedHDRPercentileRanks.fromXContent(p, (String) c));
		map.put(InternalTDigestPercentiles.NAME, (p, c) -> ParsedTDigestPercentiles.fromXContent(p, (String) c));
		map.put(InternalTDigestPercentileRanks.NAME,
				(p, c) -> ParsedTDigestPercentileRanks.fromXContent(p, (String) c));
		map.put(PercentilesBucketPipelineAggregationBuilder.NAME,
				(p, c) -> ParsedPercentilesBucket.fromXContent(p, (String) c));
		map.put(MedianAbsoluteDeviationAggregationBuilder.NAME,
				(p, c) -> ParsedMedianAbsoluteDeviation.fromXContent(p, (String) c));
		map.put(MinAggregationBuilder.NAME, (p, c) -> ParsedMin.fromXContent(p, (String) c));
		map.put(MaxAggregationBuilder.NAME, (p, c) -> ParsedMax.fromXContent(p, (String) c));
		map.put(SumAggregationBuilder.NAME, (p, c) -> ParsedSum.fromXContent(p, (String) c));
		map.put(AvgAggregationBuilder.NAME, (p, c) -> ParsedAvg.fromXContent(p, (String) c));
		map.put(ValueCountAggregationBuilder.NAME, (p, c) -> ParsedValueCount.fromXContent(p, (String) c));
		map.put(InternalSimpleValue.NAME, (p, c) -> ParsedSimpleValue.fromXContent(p, (String) c));
		map.put(DerivativePipelineAggregationBuilder.NAME, (p, c) -> ParsedDerivative.fromXContent(p, (String) c));
		map.put(InternalBucketMetricValue.NAME, (p, c) -> ParsedBucketMetricValue.fromXContent(p, (String) c));
		map.put(StatsAggregationBuilder.NAME, (p, c) -> ParsedStats.fromXContent(p, (String) c));
		map.put(StatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedStatsBucket.fromXContent(p, (String) c));
		map.put(ExtendedStatsAggregationBuilder.NAME, (p, c) -> ParsedExtendedStats.fromXContent(p, (String) c));
		map.put(ExtendedStatsBucketPipelineAggregationBuilder.NAME,
				(p, c) -> ParsedExtendedStatsBucket.fromXContent(p, (String) c));
		map.put(GeoBoundsAggregationBuilder.NAME, (p, c) -> ParsedGeoBounds.fromXContent(p, (String) c));
		map.put(GeoCentroidAggregationBuilder.NAME, (p, c) -> ParsedGeoCentroid.fromXContent(p, (String) c));
		map.put(HistogramAggregationBuilder.NAME, (p, c) -> ParsedHistogram.fromXContent(p, (String) c));
		map.put(DateHistogramAggregationBuilder.NAME, (p, c) -> ParsedDateHistogram.fromXContent(p, (String) c));
		map.put(AutoDateHistogramAggregationBuilder.NAME,
				(p, c) -> ParsedAutoDateHistogram.fromXContent(p, (String) c));
		map.put(StringTerms.NAME, (p, c) -> ParsedStringTerms.fromXContent(p, (String) c));
		map.put(LongTerms.NAME, (p, c) -> ParsedLongTerms.fromXContent(p, (String) c));
		map.put(DoubleTerms.NAME, (p, c) -> ParsedDoubleTerms.fromXContent(p, (String) c));
		map.put(MissingAggregationBuilder.NAME, (p, c) -> ParsedMissing.fromXContent(p, (String) c));
		map.put(NestedAggregationBuilder.NAME, (p, c) -> ParsedNested.fromXContent(p, (String) c));
		map.put(ReverseNestedAggregationBuilder.NAME, (p, c) -> ParsedReverseNested.fromXContent(p, (String) c));
		map.put(GlobalAggregationBuilder.NAME, (p, c) -> ParsedGlobal.fromXContent(p, (String) c));
		map.put(FilterAggregationBuilder.NAME, (p, c) -> ParsedFilter.fromXContent(p, (String) c));
		map.put(InternalSampler.PARSER_NAME, (p, c) -> ParsedSampler.fromXContent(p, (String) c));
		map.put(RangeAggregationBuilder.NAME, (p, c) -> ParsedRange.fromXContent(p, (String) c));
		map.put(DateRangeAggregationBuilder.NAME, (p, c) -> ParsedDateRange.fromXContent(p, (String) c));
		map.put(GeoDistanceAggregationBuilder.NAME, (p, c) -> ParsedGeoDistance.fromXContent(p, (String) c));
		map.put(FiltersAggregationBuilder.NAME, (p, c) -> ParsedFilters.fromXContent(p, (String) c));
		map.put(AdjacencyMatrixAggregationBuilder.NAME, (p, c) -> ParsedAdjacencyMatrix.fromXContent(p, (String) c));
		map.put(SignificantLongTerms.NAME, (p, c) -> ParsedSignificantLongTerms.fromXContent(p, (String) c));
		map.put(SignificantStringTerms.NAME, (p, c) -> ParsedSignificantStringTerms.fromXContent(p, (String) c));
		map.put(ScriptedMetricAggregationBuilder.NAME, (p, c) -> ParsedScriptedMetric.fromXContent(p, (String) c));
		map.put(IpRangeAggregationBuilder.NAME, (p, c) -> ParsedBinaryRange.fromXContent(p, (String) c));
		map.put(TopHitsAggregationBuilder.NAME, (p, c) -> ParsedTopHits.fromXContent(p, (String) c));
		map.put(CompositeAggregationBuilder.NAME, (p, c) -> ParsedComposite.fromXContent(p, (String) c));
		List<NamedXContentRegistry.Entry> entries = map.entrySet().stream()
				.map(entry -> new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(entry.getKey()),
						entry.getValue()))
				.collect(Collectors.toList());
		return entries;
	}

}
