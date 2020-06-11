package oiasso.system.examples.security.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.Rol;

public interface RoleDao extends JpaRepository<Rol, Integer> {

	Rol findByNombre(String nombre);
}
