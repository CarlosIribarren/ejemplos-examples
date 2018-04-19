package oiasso.systems.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import oiasso.systems.rest.api.facade.PersonaFacade;
import oiasso.systems.rest.api.model.Persona;

@RestController
public class PersonasRestController {

	// *********************
	// ***** Constantes ****
	// *********************

	private static final String PERSONA_NO_ENCONTRADA = "No se ha encontrado persona para el Id: "; 
	
	// *********************
	// ***** Atributos *****
	// *********************
	
	@Autowired
	private PersonaFacade personaFacade;

	// *********************
	// **** Metodos Rest ***
	// *********************
	
	@GetMapping("/personas")
	public List<Persona> obtenerTodasLasPersonas() {
		return personaFacade.obtenerTodasLasPersonas();
	}

	@GetMapping("/personas/{id}")
	public ResponseEntity obtenerPersona(@PathVariable("id") Integer id) {

		Persona persona = personaFacade.obtenerPersona(id);
		if (persona == null) {
			return new ResponseEntity(PERSONA_NO_ENCONTRADA + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(persona, HttpStatus.OK);
	}

	@PostMapping(value = "/personas")
	public ResponseEntity crearPersona(@RequestBody Persona persona) {

		personaFacade.crearPersona(persona);

		return new ResponseEntity(persona, HttpStatus.OK);
	}

	@DeleteMapping("/personas/{id}")
	public ResponseEntity borrarPersona(@PathVariable Integer id) {

		if (null == personaFacade.borrarPersona(id)) {
			return new ResponseEntity(PERSONA_NO_ENCONTRADA + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
	}

	@PutMapping("/personas/{id}")
	public ResponseEntity actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona) {

		persona = personaFacade.actualizarPersona(id, persona);

		if (null == persona) {
			return new ResponseEntity(PERSONA_NO_ENCONTRADA + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(persona, HttpStatus.OK);
	}

}
