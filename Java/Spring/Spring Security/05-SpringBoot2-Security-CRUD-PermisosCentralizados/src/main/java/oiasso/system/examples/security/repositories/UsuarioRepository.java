package oiasso.system.examples.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

	UsuarioEntity findByNombre(String nombre);
	
	void deleteByNombre(String nombre);
}
