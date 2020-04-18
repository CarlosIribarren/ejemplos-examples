package oiasso.system.examples.formatter.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

import oiasso.system.examples.formatter.dto.RolDto;
import oiasso.system.examples.formatter.dto.UsuarioDto;
import oiasso.system.examples.formatter.validators.UsuarioModificadoValidator;
import oiasso.system.examples.formatter.validators.UsuarioNuevoValidator;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	private List<UsuarioDto> usuarios;
	
	private List<RolDto> roles;
	
	public UsuarioController() {
		super();

		usuarios = new ArrayList<>();
		roles = new ArrayList<>();
		
		// Crear usuario admin
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setNombre("admin");
		usuarioDto.setContraseña("admin");
		
		Collection<RolDto> rolesAdmin = new ArrayList<>();
		RolDto rolAdmin = new RolDto();
		rolAdmin.setNombre("ROLE_ADMIN");
		
		Collection<String> privilegios = new ArrayList<>();
		privilegios.add("gestionar-usuarios");
		rolAdmin.setPrivilegios(privilegios);
		
		rolesAdmin.add(rolAdmin);
		usuarioDto.setRoles(roles);
		usuarios.add(usuarioDto);

		// Crear roles
		RolDto rolUser = new RolDto();
		rolUser.setNombre("ROLE_USER");
		roles.add(rolAdmin);
		roles.add(rolUser);
		
	}

	/***********************
	 ****** InitBinder ***** 
	 ***********************/
	
	
	@InitBinder(value = "usuarioNuevo")
	public void initBinderUsuarioNuevo(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UsuarioNuevoValidator(usuarios));
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
		modelo.addAttribute("usuarios", usuarios);
		return "usuarios/usuarios";
	}
	
	/***********************
	 ****** NUEVO ********** 
	 ***********************/
	
	@GetMapping("/new")
	public String nuevoMostrar(Model modelo) {
		modelo.addAttribute("usuarioNuevo", new UsuarioDto());
		modelo.addAttribute("listadoRoles", roles);
		return "usuarios/nuevoUsuario";
	}
	
	@PostMapping("/new")
	public String nuevoGuardar( @ModelAttribute("usuarioNuevo") @Validated UsuarioDto usuarioNuevo, BindingResult bindingResult, Model modelo) {
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("listadoRoles", roles);
			return "usuarios/nuevoUsuario";
		}
		
		usuarios.add(usuarioNuevo);
		
		return "redirect:/usuarios";
	}
	
	/***********************
	 ****** EDITAR ********* 
	 ***********************/	
	
	@GetMapping("/{nombre}")
	public String editarMostrar(@PathVariable("nombre") String nombre, Model modelo) {

		// Cargar el usuario
		UsuarioDto usuarioDto = null;
		for (UsuarioDto usuario : usuarios) {
			if(usuario.getNombre().equals(nombre)) {
				usuarioDto = usuario;
			}
		}
		
		modelo.addAttribute("usuarioModificar", usuarioDto);
		// Cargar roles
		modelo.addAttribute("listadoRoles", roles);
		return "usuarios/editarUsuario";
	}
	
	@PostMapping("/{nombre}")
	public String editarGuardar(@PathVariable("nombre") String nombre, 
								@ModelAttribute("usuarioModificar") @Validated UsuarioDto usuarioModificado, 
								BindingResult bindingResult, Model modelo) {
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("listadoRoles", roles);
			return "usuarios/editarUsuario";
		}
		
		// Cargar el usuario
		UsuarioDto usuarioDto = null;
		for (UsuarioDto usuario : usuarios) {
			if(usuario.getNombre().equals(nombre)) {
				usuarioDto = usuario;
			}
		}
		
		usuarioDto.setRoles(usuarioModificado.getRoles());
		
		
		return "redirect:/usuarios";
	}
	
	
	
	
	/***********************
	 ***** ELIMINAR ******** 
	 ***********************/
	
	@GetMapping("/{nombre}/delete")
	public String eliminar(@PathVariable("nombre") String nombre) {

		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getNombre().equals(nombre)) {
				usuarios.remove(i);
			}
			
		}
		
		return "redirect:/usuarios";
	}
	
}
