package es.eurohelp.cursos.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.eurohelp.cursos.springmvc.beans.Persona;

/**
 * Gestiona las peticiones de la página home de la aplicación.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		System.out.println("HomeController: procesando petición...");
		
		//Cuando se presenta la pantalla de INSERTAR, hay que poner como atributo el obj (vacio) que se quiere insertar
		//Para que Spring pueda llenar el obj con valores. En vez de enviar el obj vacio, se puede rellenar algun valor del obj,
		// asi saldra por defecto siempre en esa pantalla.

		model.addAttribute("persona", new Persona() );
		
        return "home";
		
	}
	
	//URL REST FULL => "/persona/new" y "POST" => INSERTAR PERSONA
	//@ModelAttribute("persona") Persona persona => Se recibe el obj Persona
	@RequestMapping(value = "/persona/new", method=RequestMethod.POST)
	public String enviarParametros(@ModelAttribute("persona") Persona persona, Model model)
	{
		model.addAttribute(persona);
		return "person";
	}
	
	
}
