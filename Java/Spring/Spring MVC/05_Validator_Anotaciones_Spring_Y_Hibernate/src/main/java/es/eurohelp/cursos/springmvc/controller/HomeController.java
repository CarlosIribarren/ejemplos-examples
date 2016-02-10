package es.eurohelp.cursos.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.eurohelp.cursos.springmvc.beans.Estudiante;
import es.eurohelp.cursos.springmvc.facade.EstudianteFacade;


/**
 * Gestiona las peticiones de la página home de la aplicación.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private EstudianteFacade estudianteFacade; 


	@RequestMapping(value = "/")
	public String home(Model model) {
		//Obtener lista de personas
		List<Estudiante> estudiantes =  estudianteFacade.listarEstudiantes();
		model.addAttribute("estudiantes", estudiantes );
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
		
		//Guardar el estudiante
		estudianteFacade.Agregar(estudiante);
		//Obtener los estudiantes para la pagina de inicio
		List<Estudiante> estudiantes =  estudianteFacade.listarEstudiantes();
		//Añadir los estudiantes al modelo
		model.addAttribute("estudiantes", estudiantes );
        return "redirect:/";
	}
	
	
}
