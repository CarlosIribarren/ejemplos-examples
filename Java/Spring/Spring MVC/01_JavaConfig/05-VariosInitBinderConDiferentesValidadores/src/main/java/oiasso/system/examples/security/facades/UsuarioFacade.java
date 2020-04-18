package oiasso.system.examples.security.facades;

import java.util.Collection;

import oiasso.system.examples.security.dto.UsuarioDto;
import oiasso.system.examples.security.entitys.UsuarioEntity;

public interface UsuarioFacade {

	UsuarioDto findByNombre(String nombre);
	
	Collection<UsuarioDto> findAll();
	
	UsuarioEntity create(UsuarioDto usuarioDto);
	
	UsuarioEntity update(UsuarioDto usuarioDto);
	
	void deleteByNombre(String nombre);
}
