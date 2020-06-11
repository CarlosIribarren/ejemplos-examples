package oiasso.system.examples.security.facades;

import java.util.Collection;

import oiasso.system.examples.security.dto.RolDto;

public interface RolFacade {

	Collection<RolDto> findAll();

}
