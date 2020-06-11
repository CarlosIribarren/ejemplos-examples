package oiasso.system.examples.security.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import oiasso.system.examples.security.entitys.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);
}
