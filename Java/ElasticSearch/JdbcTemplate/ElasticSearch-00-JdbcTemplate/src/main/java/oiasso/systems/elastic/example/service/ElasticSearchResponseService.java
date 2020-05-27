package oiasso.systems.elastic.example.service;

import org.codehaus.jackson.JsonNode;

import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterValueListDto;

public interface ElasticSearchResponseService {

	boolean isEmpty(final JsonNode response);
	
	BillingReportFilterValueListDto getSpotsResponse(final JsonNode response);
	
	BillingReportFilterValueListDto getDevicesResponse(final JsonNode response);
	
	BillingReportFilterDateRangesDto getDateRanges(final JsonNode response);
	
}
