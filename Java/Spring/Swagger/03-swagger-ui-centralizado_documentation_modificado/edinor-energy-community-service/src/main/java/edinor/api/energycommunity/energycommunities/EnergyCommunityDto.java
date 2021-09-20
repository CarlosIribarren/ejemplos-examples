package edinor.api.energycommunity.energycommunities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import edinor.api.energycommunity.model.CustomerLeadDto;
import edinor.api.energycommunity.model.PhotovoltaicInstallationDto;
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
public class EnergyCommunityDto {

	@ApiModelProperty(required = false, example = "4a065a86-8ea0-4755-a503-cea4970ea021", value = "UUID of energy community")
	private UUID uuid;
	
	@ApiModelProperty(required = true, example = "Estación de Servicio de Munoa", value = "Name of energy community")
	@NotNull
	private String name;
	
	@ApiModelProperty(required = false, example = "solar-community", value = "Type of energy community")
	private String type;
	
	@ApiModelProperty(required = false, example = "false", value = "Is complete energy community ")
	private Boolean isComplete;
	
	@ApiModelProperty(required = true, value = "Photovoltaic installations of energy community ")
	@NotNull
	@Builder.Default
	private List<PhotovoltaicInstallationDto> installations = new ArrayList<>();
	
	
	@ApiModelProperty(value = "Customer lead wait list of energy community")
	@NotNull
	@Builder.Default
	private List<CustomerLeadDto> waitingCustomerLeads = new ArrayList<>();
	
}
