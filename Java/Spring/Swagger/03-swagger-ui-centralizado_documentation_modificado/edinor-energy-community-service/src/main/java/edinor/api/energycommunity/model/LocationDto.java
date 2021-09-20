package edinor.api.energycommunity.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Location" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

	
	@ApiModelProperty(required = true, example = "43.279980", value = "Latitude")
	private BigDecimal latitude;
	
	@ApiModelProperty(required = true, example = "-2.978720", value = "Longitude")
	private BigDecimal longitude;
	
}
