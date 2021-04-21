package oiasso.systems.examples.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ResponseDto" )
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

	@ApiModelProperty
	private GranularityEnum granularity;
	
	@ApiModelProperty
	private String tipo;
	
}
