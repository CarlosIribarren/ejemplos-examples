package oiasso.systems.spring.cloud.config.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${message.hello}")
	private String message;
	
	@GetMapping("/")
	public String hello() {
		return message;
		
	}
	
}
