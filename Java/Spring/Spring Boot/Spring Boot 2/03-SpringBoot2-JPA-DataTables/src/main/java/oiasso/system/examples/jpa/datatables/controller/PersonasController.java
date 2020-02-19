package oiasso.system.examples.jpa.datatables.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonasController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String inicio() {
		return "inicio";
	}
}
