package es.ibil.edinor.api.installationstudies.studies;

import javax.validation.constraints.NotNull;

import es.ibil.edinor.api.installationstudies.model.AddressDto;
import es.ibil.edinor.api.installationstudies.model.SupplyInterfaceDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "InstallationStudyData" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallationStudyDataDto {

	@ApiModelProperty(required = true, value = "Supply interface of installation study")
	private SupplyInterfaceDto supplyInterface;
	
	@ApiModelProperty(required = true, value = "Address of installation study")
	@NotNull
	private AddressDto address;
	
}
