package oiasso.systems.elastic.client.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BillingReportFilterValueListDto {

	/** List of Values */
	private List<ValueText> list;

	/** Date max and min */
	private BillingReportFilterDateRangesDto dates;

	public BillingReportFilterValueListDto() {
		super();
		list = new ArrayList<>();
		dates = new BillingReportFilterDateRangesDto();
	}

	public List<ValueText> getList() {
		return list;
	}

	public void setList(List<ValueText> list) {
		this.list = list;
	}

	public BillingReportFilterDateRangesDto getDates() {
		return dates;
	}

	public void setDates(BillingReportFilterDateRangesDto dates) {
		this.dates = dates;
	}

}
