package es.ibil.edinor.api.energycommunities.energycommunitieslead;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ibil.edinor.api.energycommunities.mockData.Data;
import es.ibil.edinor.api.energycommunities.model.CustomerLeadDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Energy communities lead")
@RequestMapping("/energy-communities-lead")
@RestController
public class EnergyCommunitiesLeadController {

	@ApiOperation(value = "Add customer lead to energy community lead.")
	@PutMapping("/{energyCommunityLeadUuid}/wait-list")
	public ResponseEntity<Object> addCustomerLeadToEnergyCommunityLead(
			@ApiParam(value = "Energy community lead UUID", example = "3e7322a7-bc8a-488a-aa32-27e6208e3f68", required = true)
			@PathVariable(required = true) final UUID energyCommunityLeadUuid, 
			@ApiParam(value = "CustomerLead", required = true)
			@RequestBody(required = true) final @Valid CustomerLeadDto customerLeadDto) {
		
		final EnergyCommunityLeadDto energyCommunityLead = Data.mockCommunityLead.stream()
				  .filter(c -> energyCommunityLeadUuid.equals(c.getUuid()))
				  .findAny()
				  .orElse(null);
		
		if(energyCommunityLead == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		energyCommunityLead.setLead(customerLeadDto);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}