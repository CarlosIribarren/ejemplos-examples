package oiasso.systems.examples.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="Example")
@RestController
public class ExampleController {

	
	@ApiOperation(value = "Example to GranularityEnum",
			notes = "Binding GranularityEnum and response obj with GranularityEnum")
	@GetMapping("/example/{granularity}")
	public ResponseEntity<ResponseDto> example(
			@ApiParam(value = "Granularity", required = true)
			@PathVariable(required = true) final GranularityEnum granularity){
		
		ResponseDto responseDto = ResponseDto.builder()
				.granularity(granularity)
				.build();
		
		if(granularity.equals(GranularityEnum.HOURLY_EJEMPLO)) {
			responseDto.setTipo("Es de tipo Hourly. Ejemplo para utilizar el enum en las clases java");
		}
		
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
		
}