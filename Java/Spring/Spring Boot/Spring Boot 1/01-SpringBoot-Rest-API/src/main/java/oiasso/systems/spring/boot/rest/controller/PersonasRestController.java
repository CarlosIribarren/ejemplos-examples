package oiasso.systems.spring.boot.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import oiasso.systems.spring.boot.rest.beans.Persona;
import oiasso.systems.spring.boot.rest.facade.PersonaFacade;

@RestController
public class PersonasRestController {

	// *********************
	// ***** Constantes ****
	// *********************

	private static final Logger log = LoggerFactory.getLogger(PersonasRestController.class);

	private static final String PERSONA_NO_ENCONTRADA = "No se ha encontrado persona para el Id: ";

	// *********************
	// ***** Atributos *****
	// *********************

	public PersonasRestController() {
		super();
		log.info("******************* Entrando ");
	}

	@Autowired
	private PersonaFacade personaFacade;

	// *********************
	// **** Metodos Rest ***
	// *********************

	@GetMapping("/personas")
	public List<Persona> obtenerTodasLasPersonas() {

		log.info("******************* Entrando ");

		List<Persona> lista = new ArrayList<>();
		Persona p = new Persona();
		p.setId(1);
		p.setNombre("n1");
		lista.add(p);

		return lista;

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

		Persona persona = personaFacade.obtenerPersona(id);
		if (persona == null) {
			return new ResponseEntity(PERSONA_NO_ENCONTRADA + id, HttpStatus.NOT_FOUND);
		} else {
			personaFacade.borrarPersona(id);
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
