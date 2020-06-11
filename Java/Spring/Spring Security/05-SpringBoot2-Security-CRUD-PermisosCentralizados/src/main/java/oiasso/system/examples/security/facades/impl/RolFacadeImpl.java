package oiasso.system.examples.security.facades.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.dto.RolDto;
import oiasso.system.examples.security.dto.converters.RolConversorDto;
import oiasso.system.examples.security.entitys.RolEntity;
import oiasso.system.examples.security.facades.RolFacade;
import oiasso.system.examples.security.repositories.RoleRepository;

@Component
public class RolFacadeImpl implements RolFacade {

	@Autowired
	private RoleRepository roleRepository; 
	
	@Autowired
	private RolConversorDto rolConversorDto; 
	
	@Override
	public Collection<RolDto> findAll() {
		List<RolEntity> rolesEntity = roleRepository.findAll();
		return rolConversorDto.fromEntity(rolesEntity);
	}

}
