package oiasso.system.examples.formatter.validators;

import java.util.Collection;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import oiasso.system.examples.formatter.dto.RolDto;
import oiasso.system.examples.formatter.dto.UsuarioDto;

public class UsuarioNuevoValidator implements Validator {

	private List<UsuarioDto> usuarios; 

	public UsuarioNuevoValidator(List<UsuarioDto> usuarios) {
		super();
		this.usuarios = usuarios;
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
				
				// Usuario duplicado
				for (UsuarioDto usuario : usuarios) {
					if(usuario.getNombre().equals(nombre)) {
						errors.rejectValue("nombre", "usuario.nombre.duplicado");
					}
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
