package es.ibil.edinor.api.installationstudies.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase es provisional, hay que decidir que hacer, si crear mas clases, si eliminar,...
 * Depende de que informacion quieren tratar,...
 */

@ApiModel(value = "Address" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

	@ApiModelProperty(required = true, example = "Pais vasco", value = "Autonomous community")
	private String autonomousCommunity;
	
	@ApiModelProperty(required = true, example = "Bizkaia", value = "Province name")
	@NotNull
	private String province;
	
	@ApiModelProperty(required = true, example = "Barakaldo", value = "Municipality name")
	@NotNull
	private String municipality;
	
	@ApiModelProperty(required = true, example = "48903", value = "Postal code")
	@NotNull
	private Integer postalCode;
	
	@ApiModelProperty(required = true, example = "Munoa Kalea", value = "Street name")
	@NotNull
	private String street;
	
	@ApiModelProperty(required = true, example = "2", value = "Street number")
	@NotNull
	private String streetNumber;
	
	@ApiModelProperty(required = false, example = "1º A", value = "Door")
	private String door;
	
	@ApiModelProperty(required = true, example = "ChIJDzqHRohQTg0RGMbuXBowEqY", value = "Google place ID")
	private String googlePlaceId;
	
	@ApiModelProperty(required = true, example = "Munoa Kalea 2, Barakaldo, Bizkaia - 48903", value = "Complete address")
	private String address;
	
	@ApiModelProperty(required = true, example = "1º A", value = "Extra data of Address")
	private String extraData;
	
	

	

	

	

	

	
}
