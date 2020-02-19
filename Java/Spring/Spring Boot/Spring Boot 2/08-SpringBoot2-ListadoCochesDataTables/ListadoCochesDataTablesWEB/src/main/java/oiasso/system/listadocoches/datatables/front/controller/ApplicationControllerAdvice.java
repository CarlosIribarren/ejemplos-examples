package oiasso.system.listadocoches.datatables.front.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import oiasso.system.listadocoches.datatables.front.validators.FiltroCochesValidator;

/**
 * Para no tener que estar copiando en todos los controladores el metodo
 * con @IniBinder, para registrar los validadores. Esta clase contiene la
 * configuracion generica que comparten todos los controladores.
 */

@ControllerAdvice
public class ApplicationControllerAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationControllerAdvice.class);

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(new FiltroCochesValidator());
	}


	// *************************
	// ***** Otros Errores  ****
	// *************************
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleErrorException(HttpServletRequest req, Exception ex) {
		LOG.error("Error general ", ex);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		return mav;
	}

}
