package oiasso.systems.elastic.example.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BillingReportFilterValueListDto {

	/** List of Values */
	private List<ValueText> list;
	
	/** Date max and min */
	private BillingReportFilterDateRangesDto dates;
	
	public BillingReportFilterValueListDto() {
		list =  new ArrayList<>();
		dates = new BillingReportFilterDateRangesDto();
	}

}
