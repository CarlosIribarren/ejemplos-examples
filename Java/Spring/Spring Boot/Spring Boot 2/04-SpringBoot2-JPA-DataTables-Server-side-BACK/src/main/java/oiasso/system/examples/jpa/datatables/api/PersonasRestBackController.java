package oiasso.system.examples.jpa.datatables.api;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oiasso.system.examples.jpa.datatables.facade.PersonaFacade;
import oiasso.system.examples.jpa.datatables.helpers.RestResponsePersonaPage;

@RestController
@RequestMapping("/api")
public class PersonasRestBackController {

	// *********************
	// ***** Constantes ****
	// *********************

	private static final Logger LOG = LoggerFactory.getLogger(PersonasRestBackController.class);

	// *********************
	// ***** Atributos *****
	// *********************

	@Autowired
	private PersonaFacade personaFacade;

	// *********************
	// **** Metodos Rest ***
	// *********************

//	@RequestMapping(value = "personassfd", 
//					method = RequestMethod.POST, 
//					produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Iterable<Persona>> findAll(){
//		try {
//			return new ResponseEntity<Iterable<Persona>>( personaFacade.obtenerTodasLasPersonas() , HttpStatus.OK);
//		} catch (Exception e) {
//			LOG.error("Error en la llamda [/personas] ", e);
//			return new ResponseEntity<Iterable<Persona>>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@RequestMapping(value = "personas", method = RequestMethod.GET)
	public ResponseEntity<RestResponsePersonaPage> findAllPaging(
			@RequestHeader(value = "page", required = true, defaultValue = "0") Integer page,
			@RequestHeader(value = "size", required = true, defaultValue = "1") Integer size,
			@RequestHeader(value = "sortColumnName", required = true, defaultValue = "id") String sortColumnName,
			@RequestHeader(value = "sortDirection", required = true, defaultValue = "asc") String sortDirection,
			@RequestHeader(value = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
			@RequestHeader(value = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
		try {
			// Crear obj Pageable
			Sort sort;
			if ("asc".equals(sortDirection)) {
				sort = Sort.by(Sort.Direction.ASC, sortColumnName);
			} else {
				sort = Sort.by(Sort.Direction.DESC, sortColumnName);
			}

			Pageable pageable = PageRequest.of(page, size, sort);

			RestResponsePersonaPage responsePersonaPage;
			if (fechaInicio == null || fechaFin == null) {
				responsePersonaPage = personaFacade.getAllPersona(pageable);
			} else {
				responsePersonaPage = personaFacade.buscarEntreDosFechas(fechaInicio, fechaFin, pageable);
			}

			return new ResponseEntity<RestResponsePersonaPage>(responsePersonaPage, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error("Error en la llamda [/api/personas] ", e);
			return new ResponseEntity<RestResponsePersonaPage>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
