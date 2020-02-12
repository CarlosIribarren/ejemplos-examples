package oiasso.system.examples.jpa.datatables.front.services;

import java.net.URISyntaxException;

import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

import oiasso.system.examples.jpa.datatables.back.beans.Persona;
import oiasso.system.examples.jpa.datatables.front.helpers.FiltroPersonas;

public interface PersonaService {

	ResponseEntity<PagedModel<Persona>> getPersonasFiltered(Integer elementosPorPagina, String sortDirection,
			String sortColumnName, Integer numeroDePagina, FiltroPersonas filtroPersonas) throws URISyntaxException;
}
