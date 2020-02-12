package oiasso.system.examples.jpa.datatables.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import oiasso.system.examples.jpa.datatables.beans.Persona;

/**
 * Spring implementa los metodos de la interface PagingAndSortingRepository y
 * CrudRepository por nosotros.
 *
 * Tambien podemos definir metodos con la sintaxis reservada de Spring Data para
 * generar metodos: - And, Or, Between, LessThan,...
 */
@RepositoryRestResource(collectionResourceRel = "personas1", path = "personas")
public interface PersonaDao extends PagingAndSortingRepository<Persona, Integer> {

	/**
	 * Metodos personalizados definidos con la sintaxis de Spring Data. Si se
	 * declaran, tambien los implementa Spring Data por nosotros.
	 * 
	 * En este caso retorna los valores que estan entre dos id, los valores del
	 * limite del rango tambien se incluyen.
	 * 
	 * Ejemplo:
	 * 
	 * Llamda: Entre 2 y 4:
	 * 
	 * Resultado: 2,3,4
	 * 
	 */

	List<Persona> findByIdBetween(Integer inicio, Integer fin);

	List<Persona> findByFechaBetween(LocalDate inicio, LocalDate fin);

}
