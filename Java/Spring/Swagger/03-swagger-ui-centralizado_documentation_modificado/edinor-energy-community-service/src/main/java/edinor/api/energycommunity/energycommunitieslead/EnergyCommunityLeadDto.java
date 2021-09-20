package edinor.api.energycommunity.energycommunitieslead;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import edinor.api.energycommunity.model.AddressDto;
import edinor.api.energycommunity.model.CustomerLeadDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnergyCommunityLeadDto {

	@ApiModelProperty(required = false, example = "4a065a86-8ea0-4755-a503-cea4970ea021", value = "UUID of energy community lead")
	private UUID uuid;
	
	@ApiModelProperty(required = true, value = "Address of energy community lead")
	private AddressDto address;
	
	@ApiModelProperty(value = "Customer lead wait for energy community lead")
	@NotNull
	private CustomerLeadDto lead;
	
}
