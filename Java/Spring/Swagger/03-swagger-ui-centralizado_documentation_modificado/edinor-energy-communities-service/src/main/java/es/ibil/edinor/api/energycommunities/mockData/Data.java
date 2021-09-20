package es.ibil.edinor.api.energycommunities.mockData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import es.ibil.edinor.api.energycommunities.energycommunities.EnergyCommunityDto;
import es.ibil.edinor.api.energycommunities.energycommunitieslead.EnergyCommunityLeadDto;
import es.ibil.edinor.api.energycommunities.model.AddressDto;
import es.ibil.edinor.api.energycommunities.model.LocationDto;
import es.ibil.edinor.api.energycommunities.model.PhotovoltaicInstallationDto;
import es.ibil.edinor.api.energycommunities.model.SupplyInterfaceDto;

public class Data {

	public static List<EnergyCommunityDto> mockCommunities; 
	public static List<EnergyCommunityLeadDto> mockCommunityLead;
	
	static {
		mockCommunityLead = new ArrayList<>();
		mockCommunities = loadData();
	}
	
	
	private static List<EnergyCommunityDto> loadData() {
		
		// 1
		
		final AddressDto address1 = AddressDto.builder()
				.autonomousCommunity("Euskadi")
				.province("Bizkaia")
				.municipality("Barakaldo")
				.street("Munoa Kalea")
				.streetNumber("31")
				.postalCode(48903)
				.build();

		final LocationDto location1 = LocationDto.builder()
				.latitude(BigDecimal.valueOf(43.279980))
				.longitude(BigDecimal.valueOf(-2.978720))
				.build();
		
		final SupplyInterfaceDto supplyInterface1 = SupplyInterfaceDto.builder()
				.address(address1)
				.cups("ES0022876543211234ABOF")
				.build();
		
		final PhotovoltaicInstallationDto installation1 = PhotovoltaicInstallationDto.builder()
				.uuid(UUID.randomUUID())
				.name("Munoa Kalea instalacion")
				.type(2)
				.status(1)
				.connectedClients(12)
				.maxClients(50)
				.isComplete(false)
				.address(address1)
				.location(location1)
				.supplyInterface(supplyInterface1)
				.build();
		
		final List<PhotovoltaicInstallationDto> installations1 = List.of(installation1);
		
		
		final EnergyCommunityDto energyCommunity1 = EnergyCommunityDto.builder()
				.uuid(UUID.randomUUID())
				.name("Estación de Servicio de Munoa")
				.type("solar-community")
				.isComplete(false)
				.installations(installations1)
				.build();
		
		// 2
		
		final AddressDto address2 = AddressDto.builder()
				.autonomousCommunity("Euskadi")
				.province("Bizkaia")
				.municipality("Bilbao")
				.street("Alameda de Mazarredo")
				.streetNumber("4")
				.postalCode(48001)
				.build();

		final LocationDto location2 = LocationDto.builder()
				.latitude(BigDecimal.valueOf(43.262430))
				.longitude(BigDecimal.valueOf(-2.929200))
				.build();
		
		
		final SupplyInterfaceDto supplyInterface2 = SupplyInterfaceDto.builder()
				.address(address1)
				.cups("ES0022876543211234ABOF")
				.build();
		
		final PhotovoltaicInstallationDto installation2 = PhotovoltaicInstallationDto.builder()
				.uuid(UUID.randomUUID())
				.name("Alameda de Mazarredo instalacion")
				.type(1)
				.status(1)
				.connectedClients(26)
				.maxClients(60)
				.isComplete(false)
				.address(address2)
				.location(location2)
				.supplyInterface(supplyInterface2)
				.build();
		
		final List<PhotovoltaicInstallationDto> installations2 = List.of(installation2);
		
		final EnergyCommunityDto energyCommunity2 = EnergyCommunityDto.builder()
				.uuid(UUID.randomUUID())
				.name("Comunidad de vecinos Alameda de Mazarredo 4")
				.type("neighboring-community")
				.isComplete(false)
				.installations(installations2)
				.build();		
		

		return List.of(energyCommunity1, energyCommunity2);
	}
	
}
