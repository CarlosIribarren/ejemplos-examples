package oiasso.systems.elastic.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter 
public class BillingReportFilterDateRangesDto {

	/** Min date */
	private String min;
	
	/** Max date */
	private String max;

}
