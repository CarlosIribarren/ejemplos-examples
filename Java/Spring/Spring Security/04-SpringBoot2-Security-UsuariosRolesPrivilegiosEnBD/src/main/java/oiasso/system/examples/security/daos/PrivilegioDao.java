package oiasso.system.examples.security.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.Privilegio;

public interface PrivilegioDao extends JpaRepository<Privilegio, Integer> {

	Privilegio findByNombre(String nombre);
}
