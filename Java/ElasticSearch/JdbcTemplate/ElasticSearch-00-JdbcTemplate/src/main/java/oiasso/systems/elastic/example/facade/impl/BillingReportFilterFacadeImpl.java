package oiasso.systems.elastic.example.facade.impl;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.facade.BillingReportFilterFacade;
import oiasso.systems.elastic.example.factory.ElasticSearchQueryBuilderFactory;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterValueListDto;
import oiasso.systems.elastic.example.service.ElasticSearchRequestService;
import oiasso.systems.elastic.example.service.ElasticSearchResponseService;

@Service
public class BillingReportFilterFacadeImpl implements BillingReportFilterFacade {

	private final ElasticSearchRequestService requestService;
	
	private final ElasticSearchResponseService responseService;

	private final ElasticSearchQueryBuilderFactory queryBuilderFactory;
	
	@Autowired
	public BillingReportFilterFacadeImpl(final ElasticSearchRequestService elasticSearchRequestService,
			final ElasticSearchResponseService responseService,
			final ElasticSearchQueryBuilderFactory elasticSearchQueryBuilderFactory) {
		super();
		this.requestService = elasticSearchRequestService;
		this.responseService = responseService;
		this.queryBuilderFactory = elasticSearchQueryBuilderFactory;
	}

	@Override
	public BillingReportFilterValueListDto getSpots() throws ElasticSearchConsultException {
		final String query = queryBuilderFactory.createSpotsQuery();
		final JsonNode response = requestService.executeSearchRequest(query);
		if(responseService.isEmpty(response)){
			return new BillingReportFilterValueListDto();
		}
		return responseService.getSpotsResponse(response);
	}
	
	@Override
	public BillingReportFilterValueListDto getDevices(final Long spotId) throws ElasticSearchConsultException {
		final String query = queryBuilderFactory.createDevicesQuery(spotId);
		final JsonNode response = requestService.executeSearchRequest(query);
		if(responseService.isEmpty(response)){
			return new BillingReportFilterValueListDto();
		}
		return responseService.getDevicesResponse(response);
	}

	@Override
	public BillingReportFilterDateRangesDto getDateRanges() throws ElasticSearchConsultException {
		final String query = queryBuilderFactory.createDateRangesQuery();
		final JsonNode response = requestService.executeSearchRequest(query);
		if(responseService.isEmpty(response)){
			return new BillingReportFilterDateRangesDto();
		}
		return responseService.getDateRanges(response);
	}
}
