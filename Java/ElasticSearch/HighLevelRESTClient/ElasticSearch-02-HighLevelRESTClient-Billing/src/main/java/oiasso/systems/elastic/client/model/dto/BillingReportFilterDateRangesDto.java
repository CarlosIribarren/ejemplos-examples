package oiasso.systems.elastic.client.model.dto;

public class BillingReportFilterDateRangesDto {

	// ************************
	// ****** Attributes ******
	// ************************

	/** Min date */
	private String min;

	/** Max date */
	private String max;

	// ************************
	// ***** Constructor ******
	// ************************

	public BillingReportFilterDateRangesDto() {
		super();
	}

	// ************************
	// **** Getter/Setter *****
	// ************************

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

}
