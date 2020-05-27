package oiasso.systems.elastic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oiasso.systems.elastic.client.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.client.facade.BillingReportFilterFacade;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterValueListDto;

@Controller
@RequestMapping(value = "/billing/filter")
public class BillingRestController {

	@Autowired
	private BillingReportFilterFacade billingReportFilterFacade;

	@GetMapping(value = "/spots")
	public ResponseEntity<BillingReportFilterValueListDto> getSpots() throws ElasticSearchConsultException {
		return new ResponseEntity<>(billingReportFilterFacade.getSpots(), HttpStatus.OK);
	}

	@GetMapping(value = "/devices")
	public ResponseEntity<BillingReportFilterValueListDto> getDevices(
			@RequestParam(value = "spotId", required = true) final Long spotId) throws ElasticSearchConsultException {
		return new ResponseEntity<>(billingReportFilterFacade.getDevices(spotId), HttpStatus.OK);
	}

	@GetMapping(value = "/dates")
	public ResponseEntity<BillingReportFilterDateRangesDto> getDateRanges() throws ElasticSearchConsultException {
		return new ResponseEntity<>(billingReportFilterFacade.getDateRanges(), HttpStatus.OK);
	}

}