
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import DateConversor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * Todos los controllers lo traeran por defecto
 */
@ControllerAdvice
public class ModeloControllerAdvice {

  @InitBinder
  public void initBinder(final WebDataBinder binder, final HttpServletRequest request) {
	  
    binder.registerCustomEditor(Date.class, new DateConversor());

  }
}
