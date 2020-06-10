package oiasso.system.examples.security.validators;

import java.util.Collection;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import oiasso.system.examples.security.dto.RolDto;
import oiasso.system.examples.security.dto.UsuarioDto;
import oiasso.system.examples.security.facades.UsuarioFacade;

public class UsuarioNuevoValidator implements Validator {

	private UsuarioFacade usuarioFacade; 

	public UsuarioNuevoValidator(UsuarioFacade usuarioFacade) {
		super();
		this.usuarioFacade = usuarioFacade;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UsuarioDto usuarioDto = (UsuarioDto) target;

		if(usuarioDto != null) {

			final String nombre = usuarioDto.getNombre();
			if(nombre != null && nombre.isEmpty()) {
				errors.rejectValue("nombre", "campo.obligatorio");
			} else {
				
				final UsuarioDto usuarioBD = usuarioFacade.findByNombre(nombre);
				if(usuarioBD != null && usuarioBD.getNombre().equals(nombre)) {
					errors.rejectValue("nombre", "usuario.nombre.duplicado");
				}
				
			}

			
			final String contraseña = usuarioDto.getContraseña();
			if(contraseña != null && contraseña.isEmpty()) {
				errors.rejectValue("contraseña", "campo.obligatorio");
			}			

			final Collection<RolDto> roles = usuarioDto.getRoles();
			if(roles != null && roles.isEmpty()) {
				errors.rejectValue("roles", "campo.obligatorio");
			}




		}




	}

}
