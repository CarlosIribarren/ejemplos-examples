package oiasso.system.examples.data.facades;

import java.util.List;

import oiasso.system.examples.data.dtos.UsuarioDTO;

public interface UsuarioFacade {

	public List<UsuarioDTO> findAllWithRoles();
}
