package es.eurohelp.cursos.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import es.eurohelp.cursos.springmvc.beans.Estudiante;


/**
 * Gestiona las peticiones de la página home de la aplicación.
 */


//El atributo "estudiante" es de SCOPE SESION 
@SessionAttributes("estudiante")
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		//Obtener lista de personas
        return "home";
	}

//*********************************************************************************	
//***************************** PASO 1 ********************************************
//*********************************************************************************
	
	@RequestMapping(value = "/estudiante/new/paso1" , method = RequestMethod.GET)
	public String muestra_InsertarEstudiante_Paso_1_de_2(Model model) {
		model.addAttribute("estudiante", new Estudiante() );
		//Muestra el Formulario 1 de 2
        return "Estudiante_Nuevo_Paso_1_de_2";
	}
	
	@RequestMapping(value = "/estudiante/new/paso1" , method = RequestMethod.POST)
	public String redirec_Paso_2_de_2(@ModelAttribute("estudiante") Estudiante estudiante) {
		
		//Relizar validaciones...
		//En este paso solo se redirige al paso 2 
        return "redirect:/estudiante/new/paso2";
	}
	
	//*********************************************************************************	
	//***************************** PASO 2 ********************************************
	//*********************************************************************************	
	
	@RequestMapping(value = "/estudiante/new/paso2" , method = RequestMethod.GET)
	public String muestra_InsertarEstudiante_Paso_2_de_2(@ModelAttribute("estudiante") Estudiante estudiante) {
		//Muestra el Formulario 2 de 2 (Tambien hay que recibir el atributo de sesion "estudiante")
        return "Estudiante_Nuevo_Paso_2_de_2";
	}
	
	@RequestMapping(value = "/estudiante/new/paso2" , method = RequestMethod.POST)
	public String guardar_Estudiante(@ModelAttribute("estudiante") Estudiante estudiante,
			SessionStatus sessionStatus, Model model) {
		
		//Relizar validaciones...
		//Guardar el estudiante ENTERO
		//estudianteFacade.guardar(estudiante)
		System.out.println(estudiante.toString());
		
		//Borrar el atributo "estudiante" de la Sesion
		sessionStatus.setComplete();
		
		//Obtener los estudiantes para la pagina de inicio
		//Añadir los estudiantes al modelo
        return "redirect:/";
	}
	
}
