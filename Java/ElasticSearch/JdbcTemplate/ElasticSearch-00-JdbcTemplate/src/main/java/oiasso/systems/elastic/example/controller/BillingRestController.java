package oiasso.systems.elastic.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import oiasso.systems.elastic.example.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.example.facade.BillingReportFilterFacade;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.example.model.dto.BillingReportFilterValueListDto;

@Controller
@RequestMapping(value = "/billing/filter")
public class BillingRestController {

	private final BillingReportFilterFacade billingReportFilterFacade;
	
	@Autowired
	public BillingRestController(final BillingReportFilterFacade billingReportFilterFacade) {
		super();
		this.billingReportFilterFacade = billingReportFilterFacade;
	}

	@RequestMapping(value = "/spots", method = RequestMethod.GET)
	@ResponseBody
	public BillingReportFilterValueListDto getSpots() throws ElasticSearchConsultException {
		return billingReportFilterFacade.getSpots();
	}
	
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	@ResponseBody
	public BillingReportFilterValueListDto getDevices(@RequestParam(value = "spotId",required = true) final Long spotId) throws ElasticSearchConsultException {
		return billingReportFilterFacade.getDevices(spotId);
	}
	
	@RequestMapping(value = "/dates", method = RequestMethod.GET)
	@ResponseBody
	public BillingReportFilterDateRangesDto getDateRanges() throws ElasticSearchConsultException {
		return billingReportFilterFacade.getDateRanges();
	}
	
}