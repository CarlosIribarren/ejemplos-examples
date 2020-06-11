package oiasso.system.examples.security.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationControllerAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationControllerAdvice.class);


	// *************************
	// ***** Otros Errores  ****
	// *************************
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleErrorException(HttpServletRequest req, Exception ex) {
		LOG.error("Error general: {}", ex.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		return mav;
	}
	
}
