package oiasso.system.examples.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import oiasso.system.examples.security.daos.UsuarioDao;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao; 
	
	@GetMapping("/mi-usuario_detalles")
	public String detalles(Model modelo) {
		return "detalles-usuario";
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model modelo) {
		modelo.addAttribute("usuarios", usuarioDao.findAll());
		return "usuarios";
	}
	
}
