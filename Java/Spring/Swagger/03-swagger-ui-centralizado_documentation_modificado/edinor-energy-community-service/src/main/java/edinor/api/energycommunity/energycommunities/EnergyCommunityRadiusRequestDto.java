package edinor.api.energycommunity.energycommunities;

import edinor.api.energycommunity.model.AddressDto;
import edinor.api.energycommunity.model.LocationDto;
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
public class EnergyCommunityRadiusRequestDto {

	@ApiModelProperty(required = true, value = "Address to search energy community in radius")
	private AddressDto address;
	
	@ApiModelProperty(required = true, value = "Location of address to search energy community in radius")
	private LocationDto location; 
	
}
