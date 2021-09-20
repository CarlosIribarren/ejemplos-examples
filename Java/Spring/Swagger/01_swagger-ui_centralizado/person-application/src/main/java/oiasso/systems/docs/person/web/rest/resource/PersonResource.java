package oiasso.systems.docs.person.web.rest.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/person")
public class PersonResource {

	
	@GetMapping("/")
	public ResponseEntity<String> get(){
		return new ResponseEntity<>("person",HttpStatus.OK);
	}
	

}
