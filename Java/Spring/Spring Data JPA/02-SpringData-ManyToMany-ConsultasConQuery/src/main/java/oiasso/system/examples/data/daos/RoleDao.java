package oiasso.system.examples.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.data.entitys.RolEntity;

public interface RoleDao extends JpaRepository<RolEntity, Integer> {

	RolEntity findByNombre(String nombre);
	
}
