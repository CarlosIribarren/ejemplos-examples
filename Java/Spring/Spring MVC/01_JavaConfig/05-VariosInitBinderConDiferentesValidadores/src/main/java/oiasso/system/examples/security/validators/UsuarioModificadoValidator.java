package oiasso.system.examples.security.validators;

import java.util.Collection;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import oiasso.system.examples.security.dto.UsuarioDto;

public class UsuarioModificadoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UsuarioDto usuarioDto = (UsuarioDto) target;

		if(usuarioDto != null) {

			final Collection<String> roles = usuarioDto.getRoles();
			if(roles != null && roles.isEmpty()) {
				errors.rejectValue("roles", "campo.obligatorio");
			}


		}


	}

}
