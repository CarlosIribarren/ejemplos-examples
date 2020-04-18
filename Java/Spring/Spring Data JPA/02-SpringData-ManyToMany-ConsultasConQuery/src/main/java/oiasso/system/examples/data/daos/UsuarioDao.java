package oiasso.system.examples.data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oiasso.system.examples.data.entitys.UsuarioEntity;

public interface UsuarioDao extends JpaRepository<UsuarioEntity, Integer> {

	UsuarioEntity findByNombre(String nombre);
	
	@Query("SELECT u FROM usuario u INNER JOIN rol r ON u.id = r.id")
	List<UsuarioEntity> findAllWithRoles();
}
