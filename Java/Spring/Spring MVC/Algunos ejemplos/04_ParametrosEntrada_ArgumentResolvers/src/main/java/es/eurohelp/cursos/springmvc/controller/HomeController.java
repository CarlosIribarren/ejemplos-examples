package es.eurohelp.cursos.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		System.out.println("HomeController: procesando petici�n...");
		
		//Cuando se presenta la pantalla de INSERTAR, hay que poner como atributo el obj (vacio) que se quiere insertar
		//Para que Spring pueda llenar el obj con valores. En vez de enviar el obj vacio, se puede rellenar algun valor del obj,
		// asi saldra por defecto siempre en esa pantalla.

		model.addAttribute("persona", new Estudiante() );
		
        return "home";
		
	}
	
	//URL REST FULL => "/persona/new" y "POST" => INSERTAR PERSONA
	//@ModelAttribute("persona") Persona persona => Se recibe el obj Persona
	@RequestMapping(value = "/persona/new", method=RequestMethod.POST)
	public String enviarParametros(@ModelAttribute("persona") Estudiante persona, Model model)
	{
		model.addAttribute(persona);
		return "person";
	}
	
	
}
