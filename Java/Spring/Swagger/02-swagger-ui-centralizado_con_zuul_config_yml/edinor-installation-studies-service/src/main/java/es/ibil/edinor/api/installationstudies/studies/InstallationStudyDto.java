package es.ibil.edinor.api.installationstudies.studies;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import es.ibil.edinor.api.installationstudies.model.CustomerLeadDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "InstallationStudy" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstallationStudyDto {

	@ApiModelProperty(required = false, example = "cc36f4bb-4c1f-4cac-8c2b-41866dba599c", value = "UUID of installation study")
	private UUID uuid;
	
	@ApiModelProperty(required = false, example = "2021-08-07", value = "Create date of installation study")
	private LocalDate createDate;
	
	@ApiModelProperty(required = true, value = "Installation study data")
	@NotNull
	private InstallationStudyDataDto studyData;
	
	@ApiModelProperty(required = false, value = "Installation study result")
	@NotNull
	private InstallationStudyResultDto studyResult;
	
	@ApiModelProperty(required = true, value = "Customer lead of installation study")
	@NotNull
	private CustomerLeadDto customerLead;
	
}
