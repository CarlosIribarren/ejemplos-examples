package oiasso.system.listadocoches.datatables.front.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.datatables.front.abstracts.HateoasCallsUtilsAbstract;
import oiasso.system.listadocoches.datatables.front.beans.FiltroCoche;
import oiasso.system.listadocoches.datatables.front.exception.ListadoCochesRestApiException;
import oiasso.system.listadocoches.datatables.front.services.CocheService;
import oiasso.system.listadocoches.datatables.front.variables.VariablesEntornoListadoCochesWEB;

@Service
public class CocheServiceImpl extends HateoasCallsUtilsAbstract implements CocheService {
	
	@Autowired
	private VariablesEntornoListadoCochesWEB variablesEntornoListadoCochesWEB; 
	
	
	@Override
	public ResponseEntity<PagedModel<Coche>> getCochesFiltered(Integer elementosPorPagina, String sortDirection,
			String sortColumnName, Integer numeroDePagina, FiltroCoche filtroCoche) throws ListadoCochesRestApiException {

		LocalDate fechaInicio = filtroCoche.getFechaInicio();
		LocalDate fechaFin = filtroCoche.getFechaFin();

		UriComponentsBuilder builder = null;

		if (fechaInicio != null && fechaFin != null) {
			
			try {
				// Los parametros de la URL se tiene que llamar como estan definidos en los
				// atributos del metodo, y son obligatorios, si no llegan a la API da error
				// Ejemplo: findByFechaBetween(LocalDate inicio, LocalDate fin ...)				
				builder = UriComponentsBuilder
						.fromHttpUrl( variablesEntornoListadoCochesWEB.getApiCochesHost() + "/api/coche/search/findByFechaMatriculacionBetween")
						.queryParam("inicio", fechaInicio.toString()).queryParam("fin", fechaFin.toString());
			} catch (IllegalArgumentException e) {
				throw new ListadoCochesRestApiException("La URL esta mal formada.", e);
			}
			
		} else {
			
			try {
				builder = UriComponentsBuilder.fromHttpUrl( variablesEntornoListadoCochesWEB.getApiCochesHost() + "/api/coche");
			} catch (IllegalArgumentException e) {
				throw new ListadoCochesRestApiException("La URL esta mal formada.", e);
			}
			
		}
		
		builder.queryParam("page", numeroDePagina.toString()).queryParam("size", elementosPorPagina.toString())
				.queryParam("sort", sortColumnName + "," + sortDirection).build();

		return getPageable(builder.build().toUri(), new ParameterizedTypeReference<PagedModel<Coche>>() {});
	}

}
