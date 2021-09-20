package es.ibil.edinor.api.energycommunities.energycommunities;

import es.ibil.edinor.api.energycommunities.model.AddressDto;
import es.ibil.edinor.api.energycommunities.model.LocationDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "EnergyCommunityRadiusRequest" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnergyCommunityRadiusRequestDto {

	@ApiModelProperty(required = true, value = "Address to search energy community in radius")
	private AddressDto address;
	
	@ApiModelProperty(required = true, value = "Location of address to search energy community in radius")
	private LocationDto location; 
	
}
