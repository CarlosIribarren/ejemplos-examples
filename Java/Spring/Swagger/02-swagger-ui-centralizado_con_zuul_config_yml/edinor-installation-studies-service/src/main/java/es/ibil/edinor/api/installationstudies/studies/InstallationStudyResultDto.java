package es.ibil.edinor.api.installationstudies.studies;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "InstallationStudyResult" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallationStudyResultDto {

	@ApiModelProperty(required = true, example = "10000", value = "Cost Total of installation")
	@NotNull
	private Double costTotal;
	
	@ApiModelProperty(required = true, example = "2000", value = "Cost Total of installation")
	@NotNull
	private Double costPerCustomer;
	
	@ApiModelProperty(required = true, example = "1200", value = "Annual billing saving")
	@NotNull
	private Double annualBillingSaving;
	
	@ApiModelProperty(required = true, example = "36", value = "Return period of inversion in months")
	@NotNull
	private Integer returnPeriodMonths;
	
}
