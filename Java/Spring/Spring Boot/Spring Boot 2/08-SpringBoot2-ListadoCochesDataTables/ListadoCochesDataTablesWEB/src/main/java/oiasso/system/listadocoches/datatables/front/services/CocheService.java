package oiasso.system.listadocoches.datatables.front.services;

import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

import oiasso.system.listadocoches.api.beans.Coche;
import oiasso.system.listadocoches.datatables.front.beans.FiltroCoche;
import oiasso.system.listadocoches.datatables.front.exception.ListadoCochesRestApiException;

public interface CocheService {

	/**
	 * Obtiene un listado de coches paginado. Si se pasa el filtro relleno, se filtra.
	 * Si el filtro viene vacio, no se hace ningun filtrado.
	 * Siempre se hace el paginado en funcion de los parametros de paginado.
	 * 
	 * @param elementosPorPagina Elementos por pagina 
	 * @param sortDirection Direccion de ordenacion
	 * @param sortColumnName Nombre de la columna para ordenar
	 * @param numeroDePagina Numero de pagina que se quiere 
	 * @param filtroCoche Filtrodo de coches 
	 * @return Retorna una lista paginada de Coches
	 * @throws ListadoCochesRestApiException 
	 */
	ResponseEntity<PagedModel<Coche>> getCochesFiltered(Integer elementosPorPagina, String sortDirection,
			String sortColumnName, Integer numeroDePagina, FiltroCoche filtroCoche) throws ListadoCochesRestApiException;
}
