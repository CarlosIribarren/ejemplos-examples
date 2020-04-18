package oiasso.system.examples.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.PrivilegioEntity;

public interface PrivilegioRepository extends JpaRepository<PrivilegioEntity, Integer> {

	PrivilegioEntity findByNombre(String nombre);
}
