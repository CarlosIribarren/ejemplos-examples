package oiasso.systems.docs.employee.web.rest.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/employee")
public class EmployeeResource {

	
	@GetMapping("/")
	public ResponseEntity<String> get(){
			return new ResponseEntity<>("employee",HttpStatus.OK);
	
	}
	

}
