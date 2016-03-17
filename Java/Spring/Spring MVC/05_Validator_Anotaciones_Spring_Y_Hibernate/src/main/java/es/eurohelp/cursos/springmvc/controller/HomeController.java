package es.eurohelp.cursos.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.eurohelp.cursos.springmvc.beans.Estudiante;


/**
 * Gestiona las peticiones de la p�gina home de la aplicaci�n.
 */
@Controller
public class HomeController {


	@RequestMapping(value = "/")
	public String home(Model model) {
        return "home";
	}
	
	@RequestMapping(value = "/estudiante/new" , method = RequestMethod.GET)
	public String muestra_InsertarEstudiante(Model model) {
		model.addAttribute("estudiante", new Estudiante() );
        return "Estudiante_Nuevo";
	}
	
	@RequestMapping(value = "/estudiante/new" , method = RequestMethod.POST)
	public String guarda_Estudiante(@Validated@ModelAttribute("estudiante") Estudiante estudiante, BindingResult bindingResult, Model model) {
		
		//Si hay error, entonces se vuelve a la misma pagina
		if(bindingResult.hasErrors())
		{
			return "Estudiante_Nuevo";
		}

        return "redirect:/";
	}
	
}
