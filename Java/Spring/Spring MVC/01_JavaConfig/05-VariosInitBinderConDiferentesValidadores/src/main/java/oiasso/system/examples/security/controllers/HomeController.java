package oiasso.system.examples.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("")
	public String hola(Model modelo) {
		return "home";
	}

	@GetMapping("mi-usuario_detalles")
	public String detalles(Model modelo) {
		return "detalles-usuario";
	}
	
}
