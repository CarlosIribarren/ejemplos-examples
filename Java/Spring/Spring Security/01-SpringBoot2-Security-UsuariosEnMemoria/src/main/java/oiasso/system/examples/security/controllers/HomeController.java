package oiasso.system.examples.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String hola(Model modelo) {
		modelo.addAttribute("mensaje","hola desde thymeleaf");
		return "home";
	}

}
