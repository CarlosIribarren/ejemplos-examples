package oiasso.system.examples.jpa.datatables.front.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import oiasso.system.examples.jpa.datatables.front.validators.FiltroPersonasValidator;

/**
 * Para no tener que estar copiando en todos los controladores en metodo
 * con @IniBinder para registrar los validadores. Esta clase contiene la
 * configuracion generica que comparten todos los controladores
 *
 */

@ControllerAdvice
public class ApplicationControllerAdvice {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(new FiltroPersonasValidator());
	}
}
