package oiasso.systems.elastic.client.facade;

import oiasso.systems.elastic.client.exception.ElasticSearchConsultException;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterDateRangesDto;
import oiasso.systems.elastic.client.model.dto.BillingReportFilterValueListDto;

public interface BillingReportFilterFacade {

	/**
	 * Get a list of unique spots of billing
	 * 
	 * @return List of unique spots of billing. The maximum date and the minimum
	 *         date of all spots are also returned.
	 * @throws ElasticSearchConsultException
	 */
	BillingReportFilterValueListDto getSpots() throws ElasticSearchConsultException;

	/**
	 * Get all devices where an spot has been viewed
	 * 
	 * @param spotId Spot id
	 * @return List with all devices. The maximum date and the minimum date of these
	 *         spot are also returned.
	 * @throws ElasticSearchConsultException
	 */
	BillingReportFilterValueListDto getDevices(Long spotId) throws ElasticSearchConsultException;

	/**
	 * The maximum date and the minimum date of all billing information.
	 */
	BillingReportFilterDateRangesDto getDateRanges() throws ElasticSearchConsultException;

}
