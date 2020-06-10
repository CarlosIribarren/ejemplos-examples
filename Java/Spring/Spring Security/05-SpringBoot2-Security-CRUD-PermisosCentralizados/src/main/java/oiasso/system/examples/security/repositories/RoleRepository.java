package oiasso.system.examples.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.RolEntity;

public interface RoleRepository extends JpaRepository<RolEntity, Integer> {

	RolEntity findByNombre(String nombre);
}
