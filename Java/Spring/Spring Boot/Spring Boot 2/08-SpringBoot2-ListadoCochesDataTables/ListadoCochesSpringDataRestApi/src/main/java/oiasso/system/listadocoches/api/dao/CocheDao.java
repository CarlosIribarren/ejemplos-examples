package oiasso.system.listadocoches.api.dao;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import oiasso.system.listadocoches.api.beans.Coche;

@RepositoryRestResource(collectionResourceRel = "coche", path = "coche")
public interface CocheDao extends PagingAndSortingRepository<Coche, Integer> {

	Page<Coche> findByFechaMatriculacionBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin, Pageable pageable);

}
