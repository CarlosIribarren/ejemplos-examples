package oiasso.system.examples.security.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oiasso.system.examples.security.dto.UsuarioDto;
import oiasso.system.examples.security.facades.UsuarioFacade;
import oiasso.system.examples.security.repositories.RoleRepository;
import oiasso.system.examples.security.validators.UsuarioModificadoValidator;
import oiasso.system.examples.security.validators.UsuarioNuevoValidator;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/***********************
	 ****** InitBinder ***** 
	 ***********************/
	
	@InitBinder(value = "usuarioNuevo")
	public void initBinderUsuarioNuevo(HttpServletRequest request, WebDataBinder dataBinder) {
		dataBinder.addValidators(new UsuarioNuevoValidator(usuarioFacade));
		
	}
	
	@InitBinder("usuarioModificar")
	public void initBinderUsuarioModificado(HttpServletRequest request, WebDataBinder dataBinder) {
		dataBinder.addValidators(new UsuarioModificadoValidator());
		dataBinder.setDisallowedFields("contraseña");
	}
	
	/***********************
	 ****** LISTAR ********* 
	 ***********************/
	
	@GetMapping("")
	public String usuarios(Model modelo) {
		modelo.addAttribute("usuarios", usuarioFacade.findAll());
		return "usuarios/usuarios";
	}
	
	/***********************
	 ****** NUEVO ********** 
	 ***********************/
	
	@GetMapping("/new")
	public String nuevoMostrar(Model modelo) {
		modelo.addAttribute("usuarioNuevo", new UsuarioDto());
		modelo.addAttribute("roles", roleRepository.findAll());
		return "usuarios/nuevoUsuario";
	}
	
	@PostMapping("/new")
	public String nuevoGuardar( @ModelAttribute("usuarioNuevo") @Validated UsuarioDto usuarioNuevo, BindingResult bindingResult, Model modelo) {
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("roles", roleRepository.findAll());
			return "usuarios/nuevoUsuario";
		}
		
		usuarioFacade.create(usuarioNuevo);
		
		return "redirect:/usuarios";
	}
	
	/***********************
	 ****** EDITAR ********* 
	 ***********************/	
	
	@GetMapping("/{nombre}")
	public String editarMostrar(@PathVariable("nombre") String nombre, Model modelo) {
		// Cargar el usuario
		UsuarioDto usuarioDto = usuarioFacade.findByNombre(nombre);
		modelo.addAttribute("usuarioModificar", usuarioDto);
		// Cargar roles
		modelo.addAttribute("roles", roleRepository.findAll());
		return "usuarios/editarUsuario";
	}
	
	@PostMapping("/{nombre}")
	public String editarGuardar(@ModelAttribute("usuarioModificar") @Validated UsuarioDto usuarioModificado, BindingResult bindingResult, Model modelo) {
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("roles", roleRepository.findAll());
			return "usuarios/editarUsuario";
		}
		
		usuarioFacade.update(usuarioModificado);
		
		return "redirect:/usuarios";
	}
	
	/***********************
	 ***** ELIMINAR ******** 
	 ***********************/
	
	@GetMapping("/{nombre}/delete")
	public String eliminar(@PathVariable("nombre") String nombre) {
		usuarioFacade.deleteByNombre(nombre);
		return "redirect:/usuarios";
	}
	
}
