package oiasso.systems.jpa.paging.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oiasso.systems.jpa.paging.beans.Persona;
import oiasso.systems.jpa.paging.facade.PersonaFacade;

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

	/*********************************
	 ******** PAGINACION *************
	 *********************************
	 *
	 * Las paginas por defecto empiezan desde 0
	 * 
	 * Ejemplo de llamada: http://localhost/personas?page=0&size=2
	 *
	 *********************************/

	@GetMapping("/personas")
	Page<Persona> obtenerTodasLasPersonasPorPagina(
			@RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = true, defaultValue = "1") Integer size) {

		// Crear obj Pageable
		Pageable pageable = new PageRequest(page, size);

		return personaFacade.getAllPersona(pageable);
	}

	/************************************************************
	 ******** Metodos autogenerados por Spring Data *************
	 ************************************************************
	 * Ejemplo de llamada: http://localhost/filtrarPorId?inicio=2&fin=3
	 * 
	 ***/

	@GetMapping("/filtrarPorId")
	List<Persona> obtenerTodasLasPersonasEntreDosId(
			@RequestParam(value = "inicio", required = true, defaultValue = "0") Integer inicio,
			@RequestParam(value = "fin", required = true, defaultValue = "1") Integer fin) {

		return personaFacade.buscarEntreDosId(inicio, fin);
	}

	/**
	 * Se pone @DateTimeFormat(pattern = "yyyy-MM-dd") para indicar el formato con
	 * el que vienen las fechas
	 * 
	 * Ejemplo de llamada:
	 * http://localhost/filtrarPorFecha?inicio=2010-01-01&fin=2013-01-01
	 */

	@GetMapping("/filtrarPorFecha")
	List<Persona> obtenerTodasLasPersonasEntreDosFechas(
			@RequestParam(value = "inicio", required = true, defaultValue = "2010-01-10") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
			@RequestParam(value = "fin", required = true, defaultValue = "2020-01-10") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fin) {

		return personaFacade.buscarEntreDosFechas(inicio, fin);
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
