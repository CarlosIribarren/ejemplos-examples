package oiasso.system.examples.security.converters;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.dto.UsuarioDto;
import oiasso.system.examples.security.entitys.RolEntity;
import oiasso.system.examples.security.entitys.UsuarioEntity;
import oiasso.system.examples.security.facades.UsuarioFacade;
import oiasso.system.examples.security.repositories.RoleRepository;


@Component
public class UsuarioConverter extends AbstractConverter<UsuarioEntity, UsuarioDto > {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Override
	public UsuarioEntity fromDto(UsuarioDto dto) {
		
		if(dto==null) {return null;}
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNombre(dto.getNombre());
		usuarioEntity.setContraseña(dto.getContraseña());
		
		// Se obtienen los roles de la BD
		Collection<RolEntity> roles = new ArrayList<>();
		for (String rol : dto.getRoles()) {
			roles.add(roleRepository.findByNombre(rol));
		}
		usuarioEntity.setRoles(roles);
		
		return usuarioEntity;
	}

	public UsuarioEntity fromDtoCreate(UsuarioDto dto) {
		
		if(dto==null) {return null;}
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNombre(dto.getNombre());
		usuarioEntity.setContraseña(dto.getContraseña());
		
		// Se obtienen los roles de la BD
		Collection<RolEntity> roles = new ArrayList<>();
		for (String rol : dto.getRoles()) {
			roles.add(roleRepository.findByNombre(rol));
		}
		usuarioEntity.setRoles(roles);
		
		return usuarioEntity;
	}
	
	public UsuarioEntity fromDtoUpdate(UsuarioDto dto) {
		
		if(dto==null) {return null;}
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNombre(dto.getNombre());
		
		// Se mantiene la contraseña
		UsuarioDto usuarioDto = usuarioFacade.findByNombre(dto.getNombre());
		if(usuarioDto != null) {
			usuarioEntity.setContraseña(usuarioDto.getContraseña());
		}
		
		// Se obtienen los roles de la BD
		Collection<RolEntity> roles = new ArrayList<>();
		for (String rol : dto.getRoles()) {
			roles.add(roleRepository.findByNombre(rol));
		}
		usuarioEntity.setRoles(roles);
		
		return usuarioEntity;
	}	
	
	
	/**
	 * No se añade la contraseña.
	 */
	@Override
	public UsuarioDto fromEntity(UsuarioEntity entity) {
		
		if(entity==null) {return null;}
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setNombre(entity.getNombre());
		
		Collection<String> rolesString = new ArrayList<>();
		Collection<RolEntity> roles = entity.getRoles();
		for (RolEntity rolEntity : roles) {
			rolesString.add(rolEntity.getNombre());
		}
		
		usuarioDto.setRoles(rolesString);
		
		return usuarioDto;
	}
	

}
