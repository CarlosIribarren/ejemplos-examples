package es.ibil.edinor.api.installationstudies.studies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ibil.edinor.api.installationstudies.model.CustomerLeadDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Installation Studies")
@RequestMapping("/installation-studies")
@RestController
public class InstallationStudiesController {

	private final List<InstallationStudyDto> mock;
	
	public InstallationStudiesController() {
		mock = new ArrayList<>();
	}


	@ApiOperation(value = "Get installation study")
	@GetMapping("/{installationStudyUuid}")
	public ResponseEntity<InstallationStudyDto> getInstallationStudy(
			@ApiParam(value = "Installation study UUID", example = "c23ceb9a-4dee-48f5-a6b4-197ab02867f4", required = true)
			@PathVariable(required = true) final UUID installationStudyUuid) {
		
		final InstallationStudyDto study = mock.stream()
				  .filter(c -> installationStudyUuid.equals(c.getUuid()))
				  .findAny()
				  .orElse(null);
		
		return new ResponseEntity<>(study, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Create installation study")
	@PostMapping("/")
	public ResponseEntity<Object> createInstallationStudy(
			@ApiParam(value = "InstallationStudyData", required = true)
			@RequestBody(required = true) final @Valid InstallationStudyDataDto installationStudyDataDto) {
		
		final InstallationStudyResultDto resultDto = InstallationStudyResultDto.builder()
				.costTotal(15000.0)
				.costPerCustomer(3000.0)
				.annualBillingSaving(1050.0)
				.returnPeriodMonths(180)
				.build();
		
		final InstallationStudyDto installationStudyDto = InstallationStudyDto.builder()
				.uuid(UUID.randomUUID())
				.studyData(installationStudyDataDto)
				.studyResult(resultDto)
				.build();
		
		mock.add(installationStudyDto);
		
		final Map<String, String> uuid = Map.of("uuid",installationStudyDto.getUuid().toString() );
		
		return new ResponseEntity<>(uuid, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add customer lead to installation study for contact with him.")
	@PutMapping("/{installationStudyUuid}/candidate-customer")
	public ResponseEntity<Object> addCustomerLeadToInstallationStudy(
			@ApiParam(value = "Installation Study UUID", example = "1f04db09-3053-4123-948d-93005848569c", required = true)
			@PathVariable(required = true) final UUID installationStudyUuid,
			@ApiParam(value = "CustomerLead", required = true)
			@RequestBody(required = true) final @Valid CustomerLeadDto customerLeadDto) {
		
		final InstallationStudyDto study = mock.stream()
				  .filter(c -> installationStudyUuid.equals(c.getUuid()))
				  .findAny()
				  .orElse(null);
		
		study.setCustomerLead(customerLeadDto);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}