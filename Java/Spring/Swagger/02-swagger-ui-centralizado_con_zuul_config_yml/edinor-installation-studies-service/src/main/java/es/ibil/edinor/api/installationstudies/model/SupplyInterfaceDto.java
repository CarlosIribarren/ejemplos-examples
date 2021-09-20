package es.ibil.edinor.api.installationstudies.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "SupplyInterface" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplyInterfaceDto {

	@ApiModelProperty(required = true, example = "ES0022123456781234ABOF", value = "CUPS of supply interface")
	private String cups;
	
	@ApiModelProperty(required = true, value = "Address of supply interface")
	private AddressDto address;
	
}
