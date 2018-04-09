package es.eurohelp.cursos.springmvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Gestiona las peticiones de la página home de la aplicación.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home(Model model) {
		System.out.println("HomeController: procesando petición...");
		
		String now = (new Date()).toString();
		model.addAttribute("now", now);
		
        return "WEB-INF/jsp/home.jsp";
		
	}
	
	
}
