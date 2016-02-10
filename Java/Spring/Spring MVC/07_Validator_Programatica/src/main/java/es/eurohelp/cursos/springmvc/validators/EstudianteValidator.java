package es.eurohelp.cursos.springmvc.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.eurohelp.cursos.springmvc.beans.Estudiante;

@Component
public class EstudianteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Estudiante.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Obtener el Bean
		Estudiante estudiante = (Estudiante) target;
		//********** VALIDACIONES CON LOGICA DE NEGOCIO *******************
		//Validar Nif
		if(!"123456789-A".equals(estudiante.getNif()))
		{
			errors.rejectValue("nif", "nif.error");
		}
		//Validar que Email tiene @
		int indiceArroba = estudiante.getEmail().indexOf('@');
		if(indiceArroba==-1)
		{
			errors.rejectValue("email", "email.error");
		}
	}

}
