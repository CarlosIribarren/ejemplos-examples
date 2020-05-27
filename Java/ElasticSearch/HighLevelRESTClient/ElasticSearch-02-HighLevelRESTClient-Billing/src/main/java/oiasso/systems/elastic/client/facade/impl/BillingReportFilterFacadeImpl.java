package oiasso.systems.elastic.client.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.aggregations.metrics.ParsedMax;
import org.elasticsearch.search.aggregations.metrics.ParsedMin;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.elastic.client.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.client.facade.BillingReportFilterFacade;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterValueListDto;
import oiasso.systems.elastic.client.model.dto.ValueText;
import oiasso.systems.elastic.client.service.ElasticSearchService;

@Service
public class BillingReportFilterFacadeImpl implements BillingReportFilterFacade {

	// ************************
	// ****** Constants *******
	// ************************

	/** Name of the index */
	private static final String INDEX = "billing-*";

	/** Field spot id */
	private static final String SPOT_ID = "spot_id";

	/** Field spot name */
	private static final String SPOT_NAME = "spot_name.keyword";

	/** Field device name */
	private static final String DEVICE_NAME = "dev.keyword";

	/** Field date start name */
	private static final String DATE_START = "date_start";

	/** Field date end */
	private static final String DATE_END = "date_end";

	/** Aggregation Min date of billing */
	private static final String MIN_DATE = "minDate";

	/** Aggregation Max date of billing */
	private static final String MAX_DATE = "maxDate";

	// ************************
	// ****** Attributes ******
	// ************************

	/** ElasticSearch service */
	private ElasticSearchService elasticSearchService;

	// ************************
	// ***** Constructor ******
	// ************************

	@Autowired
	public BillingReportFilterFacadeImpl(ElasticSearchService elasticSearchService) {
		super();
		this.elasticSearchService = elasticSearchService;
	}

	// ************************
	// **** Public methods ****
	// ************************

	@Override
	public BillingReportFilterValueListDto getSpots() throws ElasticSearchConsultException {

		// Create response object
		final BillingReportFilterValueListDto response = new BillingReportFilterValueListDto();

		// Create Search
		final AggregationBuilder aggregationSpot = AggregationBuilders.terms(SPOT_ID).field(SPOT_ID)
				.subAggregation(AggregationBuilders.terms(SPOT_NAME).field(SPOT_NAME).order(BucketOrder.count(false)));

		final AggregationBuilder aggregationMinDate = AggregationBuilders.min(MIN_DATE).field(DATE_END);
		final AggregationBuilder aggregationMaxDate = AggregationBuilders.max(MAX_DATE).field(DATE_START);
		final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().aggregation(aggregationSpot)
				.aggregation(aggregationMinDate).aggregation(aggregationMaxDate).size(0);

		// Create Request
		final SearchRequest searchRequest = new SearchRequest(INDEX);
		searchRequest.source(searchSourceBuilder);

		// Executes search request
		SearchResponse searchResponse = elasticSearchService.executeSearchRequest(searchRequest,
				RequestOptions.DEFAULT);

		// Get query response
		if (searchResponse != null) {
			final Aggregations aggregationResult = searchResponse.getAggregations();
			if (aggregationResult != null) {

				// Get Spots
				response.setList(this.getSpotList(aggregationResult));

				// Get Max and Min dates
				response.setDates(this.getResultDateRanges(aggregationResult));
			}
		}

		return response;
	}

	@Override
	public BillingReportFilterValueListDto getDevices(final Long spotId) throws ElasticSearchConsultException {

		// Create response object
		final BillingReportFilterValueListDto devices = new BillingReportFilterValueListDto();

		// Create Search
		final QueryBuilder queryBuilder = QueryBuilders.boolQuery().filter(QueryBuilders.matchQuery(SPOT_ID, spotId));
		final AggregationBuilder aggregation = AggregationBuilders.terms(DEVICE_NAME).field(DEVICE_NAME);
		final AggregationBuilder aggregationMinDate = AggregationBuilders.min(MIN_DATE).field(DATE_END);
		final AggregationBuilder aggregationMaxDate = AggregationBuilders.max(MAX_DATE).field(DATE_START);
		final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(queryBuilder)
				.aggregation(aggregation).aggregation(aggregationMinDate).aggregation(aggregationMaxDate).size(0);

		// Create Request
		final SearchRequest searchRequest = new SearchRequest(INDEX);
		searchRequest.source(searchSourceBuilder);

		// Executes search request
		SearchResponse searchResponse = elasticSearchService.executeSearchRequest(searchRequest,
				RequestOptions.DEFAULT);

		// Get query response
		if (searchResponse != null) {
			// Get query response
			final Aggregations aggregationResult = searchResponse.getAggregations();
			if (aggregationResult != null) {

				// Get devices
				final ParsedStringTerms dispositivoDeAnuncio = aggregationResult.get(DEVICE_NAME);
				if (dispositivoDeAnuncio != null) {
					for (final Bucket bucket : dispositivoDeAnuncio.getBuckets()) {
						devices.getList().add(new ValueText(bucket.getKey().toString(), bucket.getKey().toString()));
					}
				}

				// Get Max and Min dates
				devices.setDates(this.getResultDateRanges(aggregationResult));

			}
		}

		return devices;
	}

	@Override
	public BillingReportFilterDateRangesDto getDateRanges() throws ElasticSearchConsultException {

		BillingReportFilterDateRangesDto dateRanges = new BillingReportFilterDateRangesDto();

		// Create Search
		final AggregationBuilder aggregationMinDate = AggregationBuilders.min(MIN_DATE).field(DATE_END);
		final AggregationBuilder aggregationMaxDate = AggregationBuilders.max(MAX_DATE).field(DATE_START);
		final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().aggregation(aggregationMinDate)
				.aggregation(aggregationMaxDate).size(0);

		// Create Request
		final SearchRequest searchRequest = new SearchRequest(INDEX);
		searchRequest.source(searchSourceBuilder);

		// Executes search request
		SearchResponse searchResponse = elasticSearchService.executeSearchRequest(searchRequest,
				RequestOptions.DEFAULT);

		// Get query response
		if (searchResponse != null) {
			final Aggregations aggregationResult = searchResponse.getAggregations();
			if (aggregationResult != null) {
				// Get Max and Min dates
				dateRanges = this.getResultDateRanges(aggregationResult);
			}
		}

		return dateRanges;
	}

	// ************************
	// **** Private methods ***
	// ************************

	private List<ValueText> getSpotList(final Aggregations aggregationResult) {

		List<ValueText> spots = new ArrayList<>();

		// Aggregation
		final ParsedLongTerms anuncios = aggregationResult.get(SPOT_ID);
		if (anuncios != null) {

			for (final org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket bucket : anuncios.getBuckets()) {

				// Get spot id
				String id = bucket.getKey().toString();

				// SubAggregations
				Aggregations subAggregations = bucket.getAggregations();
				if (subAggregations != null) {

					ParsedStringTerms spotName = subAggregations.get(SPOT_NAME);
					if (spotName != null && spotName.getBuckets() != null) {

						Bucket nameBucket = spotName.getBuckets().get(0);

						// Get spot name
						String name = nameBucket.getKeyAsString();

						spots.add(new ValueText(id, name));
					}
				}

			}
		}
		return spots;
	}

	private BillingReportFilterDateRangesDto getResultDateRanges(final Aggregations aggregationResult) {

		final BillingReportFilterDateRangesDto dateRanges = new BillingReportFilterDateRangesDto();

		final ParsedMin minDate = aggregationResult.get(MIN_DATE);
		if (minDate != null) {
			dateRanges.setMin(minDate.getValueAsString());
		}

		final ParsedMax maxDate = aggregationResult.get(MAX_DATE);
		if (maxDate != null) {
			dateRanges.setMax(maxDate.getValueAsString());
		}

		return dateRanges;
	}

}
