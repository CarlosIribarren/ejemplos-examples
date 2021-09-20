package es.ibil.edinor.api.energycommunities.model;

import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "PhotovoltaicInstallation" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotovoltaicInstallationDto {

	@ApiModelProperty(required = false, example = "b8ac41db-dd17-4752-9ec9-a5865c0498c6", value = "UUID of photovoltaic installation")
	private UUID uuid;
	
	@ApiModelProperty(required = true, example = "San mames grada este", value = "Name of photovoltaic installation")
	private String name;
	
	@ApiModelProperty(required = true, example = "1", value = "Type of photovoltaic installation")
	private Integer type;
	
	@ApiModelProperty(required = true, example = "0", value = "Status of photovoltaic installation")
	private Integer status;
	
	@ApiModelProperty(required = true, example = "16", value = "Connected clients to photovoltaic installation")
	private Integer connectedClients;
	
	@ApiModelProperty(required = true, example = "100", value = "Maximum number of Clients to connect to photovoltaic installation")
	private Integer maxClients;
	
	@ApiModelProperty(required = true, example = "false", value = "Is complete photovoltaic installation")
	private Boolean isComplete;
	
	@ApiModelProperty(required = true, value = "Address of supply interface of photovoltaic installation")
	private AddressDto address;
	
	@ApiModelProperty(required = true, value = "Supply interface of photovoltaic installation")
	private SupplyInterfaceDto supplyInterface;

	@ApiModelProperty(required = true, value = "Location of photovoltaic installation")
	private LocationDto location; 
}
