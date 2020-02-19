package oiasso.system.examples.jpa.datatables.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oiasso.system.examples.jpa.datatables.beans.Persona;
import oiasso.system.examples.jpa.datatables.facade.PersonaFacade;

@RestController
@RequestMapping("/api")
public class PersonasRestController {

	// *********************
	// ***** Constantes ****
	// *********************

	private static final Logger LOG = LoggerFactory.getLogger(PersonasRestController.class);

	// *********************
	// ***** Atributos *****
	// *********************

	@Autowired
	private PersonaFacade personaFacade;

	// *********************
	// **** Metodos Rest ***
	// *********************

	@RequestMapping(value = "personas", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Persona>> findAll(){
		try {
			return new ResponseEntity<Iterable<Persona>>( personaFacade.obtenerTodasLasPersonas() , HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error en la llamda [/personas] ", e);
			return new ResponseEntity<Iterable<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	



}
