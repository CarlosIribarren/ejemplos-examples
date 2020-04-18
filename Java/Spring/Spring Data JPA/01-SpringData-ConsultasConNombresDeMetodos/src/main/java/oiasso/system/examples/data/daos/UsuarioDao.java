package oiasso.system.examples.data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.data.entitys.UsuarioEntity;

public interface UsuarioDao extends JpaRepository<UsuarioEntity, Integer> {

	UsuarioEntity findByNombre(String nombre);
}
