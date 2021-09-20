package es.ibil.edinor.api.energycommunities.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "CustomerLead" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLeadDto {
	
	@ApiModelProperty(required = true, example = "energy-community-wait-list", value = "Type of candidate customer")
	@NotNull
	private String candidateType;
	
	@ApiModelProperty(required = true, example = "Jon", value = "Name of customer")
	@NotNull
	private String name;
	
	@ApiModelProperty(required = false, example = "Garcia Martinez", value = "Surnames of customer")
	@NotNull
	private String surnames;
	
	@ApiModelProperty(required = true, example = "645789321", value = "Phone of customer")
	@NotNull
	private String phone;
	
	@ApiModelProperty(required = true, example = "example@email.com", value = "Email of customer")
	@NotNull
	private String email;
	
	@ApiModelProperty(required = true, example = "email", value = "Contact customer by")
	@NotNull
	private String contactBy;
	
	@ApiModelProperty(required = true, example = "false", value = "Customer is registered")
	@NotNull
	private Boolean isRegisteredCustomer;
	
	@ApiModelProperty(required = false, example = "dni", value = "Document type of customer")
	private String documentType;
	
	@ApiModelProperty(required = false, example = "86219872W", value = "Document value of customer")
	private String documentValue;
	
	
}
