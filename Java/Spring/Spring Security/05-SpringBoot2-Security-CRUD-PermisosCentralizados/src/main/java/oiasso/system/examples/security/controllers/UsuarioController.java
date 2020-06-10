package oiasso.system.examples.security.controllers;

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
import oiasso.system.examples.security.facades.RolFacade;
import oiasso.system.examples.security.facades.UsuarioFacade;
import oiasso.system.examples.security.validators.UsuarioModificadoValidator;
import oiasso.system.examples.security.validators.UsuarioNuevoValidator;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	/***********************
	 ****** Constantes ***** 
	 ***********************/
	
	private final String REDIRECT_USUARIOS = "redirect:/usuarios";
	
	/***********************
	 ****** Atributos ****** 
	 ***********************/
	
	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Autowired
	private RolFacade rolFacade;
	
	/***********************
	 ****** InitBinder ***** 
	 ***********************/
	
	
	@InitBinder(value = "usuarioNuevo")
	public void initBinderUsuarioNuevo(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UsuarioNuevoValidator(usuarioFacade));
	}
	
	@InitBinder("usuarioModificar")
	public void initBinderUsuarioModificado(WebDataBinder dataBinder) {
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
		this.cargarRoles(modelo);
		return "usuarios/nuevoUsuario";
	}
	
	@PostMapping("/new")
	public String nuevoGuardar( @ModelAttribute("usuarioNuevo") @Validated UsuarioDto usuarioNuevo, BindingResult bindingResult, Model modelo) {
		
		if(bindingResult.hasErrors()) {
			this.cargarRoles(modelo);
			return "usuarios/nuevoUsuario";
		}
		
		usuarioFacade.create(usuarioNuevo);
		
		return REDIRECT_USUARIOS;
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
		this.cargarRoles(modelo);
		return "usuarios/editarUsuario";
	}
	
	@PostMapping("/{nombre}")
	public String editarGuardar(@PathVariable("nombre") String nombre, 
								@ModelAttribute("usuarioModificar") @Validated UsuarioDto usuarioModificado, 
								BindingResult bindingResult, Model modelo) {
		
		if(bindingResult.hasErrors()) {
			this.cargarRoles(modelo);
			return "usuarios/editarUsuario";
		}
		
		usuarioFacade.update(usuarioModificado);
		
		return REDIRECT_USUARIOS;
	}
	
	/***********************
	 ***** ELIMINAR ******** 
	 ***********************/
	
	@GetMapping("/{nombre}/delete")
	public String eliminar(@PathVariable("nombre") String nombre) {
		usuarioFacade.deleteByNombre(nombre);
		return REDIRECT_USUARIOS;
	}
	
	/******************************
	 ****** Metodos privados ******
	 ******************************/
	
	private void cargarRoles(Model modelo) {
		modelo.addAttribute("listadoRoles", rolFacade.findAll());
	}
	
}
