package oiasso.systems.elastic.example.service.impl;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.elastic.example.factory.ElasticSearchResponseFactory;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterValueListDto;
import oiasso.systems.elastic.example.service.ElasticSearchResponseService;
import oiasso.systems.elastic.example.util.ListOfValueTextUtils;

@Service
public class ElasticSearchResponseServiceImpl implements ElasticSearchResponseService {

	private final ElasticSearchResponseFactory responseFactory;
	
	private final ListOfValueTextUtils listOfValueTextUtils;

	@Autowired
	public ElasticSearchResponseServiceImpl(final ElasticSearchResponseFactory elasticSearchResponseFactory,
			final ListOfValueTextUtils listOfValueTextUtils) {
		super();
		this.responseFactory = elasticSearchResponseFactory;
		this.listOfValueTextUtils = listOfValueTextUtils;
	}

	@Override
	public boolean isEmpty(final JsonNode response) {
		if(response == null) { return false; }
		return "0".equals(responseFactory.getTotalHits(response));
	}
	

	@Override
	public BillingReportFilterValueListDto getSpotsResponse(final JsonNode response) {
		final BillingReportFilterValueListDto result = new BillingReportFilterValueListDto();
		result.setList(responseFactory.getSpotList(response));
		result.setDates(responseFactory.getDateRanges(response));
		listOfValueTextUtils.sortByText(result.getList());
		return result;
	}

	@Override
	public BillingReportFilterValueListDto getDevicesResponse(final JsonNode response) {
		final BillingReportFilterValueListDto result = new BillingReportFilterValueListDto();
		result.setList(responseFactory.getDevices(response));
		result.setDates(responseFactory.getDateRanges(response));
		listOfValueTextUtils.sortByText(result.getList());
		return result;
	}

	@Override
	public BillingReportFilterDateRangesDto getDateRanges(final JsonNode response) {
		return responseFactory.getDateRanges(response);
	}

}
