package oiasso.system.examples.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import oiasso.system.examples.security.dtos.NotaDTO;


@Controller
public class ApplicationController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String hola(Model model) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "");
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		
		ResponseEntity<NotaDTO[]> responseEntity = restTemplate.exchange("http://localhost:8080/api/nota/all", HttpMethod.GET, entity, NotaDTO[].class);
		
		model.addAttribute("notas", responseEntity.getBody());
		
		return "application";
	}

}
