package es.eurohelp.cursos.springmvc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.eurohelp.cursos.springmvc.facade.EstudianteFacade;
import es.eurohelp.cursos.springmvc.modelo.Estudiante;

/**
 * Gestiona las peticiones de la página home de la aplicación.
 */
@Controller
public class HomeController {

	@Autowired
	private EstudianteFacade estudianteFacade;
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		System.out.println("HomeController: procesando petición...");
		
		Estudiante estudiante = estudianteFacade.getEstudiante(1);
		
		model.addAttribute("estudiante", estudiante);
		
        return "home";
		
	}
	
	
}
