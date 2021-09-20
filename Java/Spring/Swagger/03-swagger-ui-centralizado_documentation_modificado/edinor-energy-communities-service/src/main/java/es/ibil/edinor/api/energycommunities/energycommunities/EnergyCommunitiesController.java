package es.ibil.edinor.api.energycommunities.energycommunities;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ibil.edinor.api.energycommunities.energycommunitieslead.EnergyCommunityLeadDto;
import es.ibil.edinor.api.energycommunities.mockData.Data;
import es.ibil.edinor.api.energycommunities.model.CustomerLeadDto;
import es.ibil.edinor.api.energycommunities.model.LocationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Energy communities")
@RequestMapping("/energy-communities")
@RestController
public class EnergyCommunitiesController {

	@ApiOperation(value = "Get list of all energy communities")
	@GetMapping("/")
	public ResponseEntity<List<EnergyCommunityDto>> list(
			@ApiParam(value = "Type of the energy community", example = "solar-community", required = false) @RequestParam(required = false) final String type) {

		
		if(type == null) {
			return new ResponseEntity<>(Data.mockCommunities, HttpStatus.OK);
		}
		final List<EnergyCommunityDto> energyCommunitiesFiltered = Data.mockCommunities.stream()
																	.filter(c -> c.getType().equals(type))
																	.collect(Collectors.toList());
		
		return new ResponseEntity<>(energyCommunitiesFiltered, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Get list of all energy communities within a radius of 500 meters.",
			notes = "Get list of all energy communities within a radius of 500 meters. \n"
					+ "If there is no energy communities in radius of 500 meters, a energy community lead is created and is return his UUI with a 404 response." )
	@GetMapping("/radius")
	public ResponseEntity<Object> radius(final EnergyCommunityRadiusRequestDto energyCommunityRadiusRequestDto) {

		
		
		final List<EnergyCommunityDto> energyCommunitiesFiltered = Data.mockCommunities.stream()
				.filter(c -> this.isCommunityLessThan500meters(c, energyCommunityRadiusRequestDto.getLocation()))
				.collect(Collectors.toList());
		
		// En caso de NO encontrar retorna un 404 y el UUID de la EnergyCommunityLead
		if(energyCommunitiesFiltered.isEmpty()) {
			// guardar en BD EnergyCommunityLead
			final EnergyCommunityLeadDto communityLead = EnergyCommunityLeadDto.builder()
					.uuid(UUID.randomUUID())
					.address(energyCommunityRadiusRequestDto.getAddress())
					.build();
			Data.mockCommunityLead.add(communityLead);
			
			return new ResponseEntity<>(communityLead, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(energyCommunitiesFiltered, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Add customer lead to waiting list of energy community.")
	@PutMapping("/{energyCommunityUuid}/wait-list")
	public ResponseEntity<Object> addCustomerLeadToEnergyCommunityWaitingList(
			@ApiParam(value = "Energy Community UUID", example = "3e7322a7-bc8a-488a-aa32-27e6208e3f68", required = true)
			@PathVariable(required = true) final UUID energyCommunityUuid, 
			@ApiParam(value = "CustomerLead", required = true)
			@RequestBody(required = true) final @Valid CustomerLeadDto customerLeadDto) {
		

		final EnergyCommunityDto energyCommunity = Data.mockCommunities.stream()
				  .filter(c -> energyCommunityUuid.equals(c.getUuid()))
				  .findAny()
				  .orElse(null);
		
		if(energyCommunity == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		energyCommunity.getWaitingCustomerLeads().add(customerLeadDto);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Calculate distance between point A and point B
	 * @param latA Latitude of point A
	 * @param lonA Longitude of point A
	 * @param latB Latitude of point B
	 * @param lonB Longitude of point B
	 * @return Distance in meters
	 */
    public static double getDistance(final double latA, final double lonA, final double latB, final double lonB) {
    	
    	final double EARTH_DIAMETER = 6371.01 * 1000; //meters

        final Double diffLongitudes0 = lonA - lonB ;
        final double diffLongitudes = Math.toRadians(diffLongitudes0);
        final double slat = Math.toRadians(latA);
        final double flat = Math.toRadians(latB);

        //spherical law of cosines
        final double c = Math.acos((Math.sin(slat) * Math.sin(flat)) + (Math.cos(slat) * Math.cos(flat) * Math.cos(diffLongitudes)));

        //Vincenty formula
		// double c = sqrt(pow(cos(flat) * sin(diffLongitudes), 2d) + pow(cos(slat) * sin(flat) - sin(slat) * cos(flat) * cos(diffLongitudes), 2d));
		// c = c / (sin(slat) * sin(flat) + cos(slat) * cos(flat) * cos(diffLongitudes));
		// c = atan(c);

        return EARTH_DIAMETER * c;
    }
    
    
    
    private boolean isCommunityLessThan500meters(final EnergyCommunityDto energyCommunity, final LocationDto location) {
    	return energyCommunity.getInstallations().stream().anyMatch(c -> 
    		getDistance(c.getLocation().getLatitude().doubleValue(), c.getLocation().getLongitude().doubleValue(), location.getLatitude().doubleValue(), location.getLongitude().doubleValue()) < 500);
    }
	
}