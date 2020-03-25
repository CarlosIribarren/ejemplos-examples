package oiasso.system.examples.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import oiasso.system.examples.data.facades.UsuarioFacade;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioFacade usuarioFacade; 
	
	@GetMapping("/usuarios")
	public String hola(Model model) {
		model.addAttribute("usuarios", usuarioFacade.findAllWithRoles());
		return "usuarios";
	}

}
