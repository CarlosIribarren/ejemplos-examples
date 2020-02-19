package oiasso.system.examples.jpa.datatables.validators;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import oiasso.system.examples.jpa.datatables.helpers.FiltroPersonas;

public class FiltroPersonasValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FiltroPersonas.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		FiltroPersonas filtroPersonas = (FiltroPersonas) target;

		LocalDate fechaInicio = filtroPersonas.getFechaInicio();
		LocalDate fechaFin = filtroPersonas.getFechaFin();

		if (fechaInicio != null && fechaFin != null) {
			if (fechaInicio.isAfter(fechaFin)) {
				errors.rejectValue("fechaInicio", "La fecha de inicio tiene que ser anterior a la fecha de fin");
				errors.rejectValue("fechaFin", "La fecha de fin tiene que ser posterior a la fecha de inicio");
			}

		}

	}

}
