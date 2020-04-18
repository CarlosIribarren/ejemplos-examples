package oiasso.system.examples.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.data.entitys.PrivilegioEntity;

public interface PrivilegioDao extends JpaRepository<PrivilegioEntity, Integer> {

	PrivilegioEntity findByNombre(String nombre);
}
