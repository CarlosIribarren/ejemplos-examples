package oiasso.system.examples.security.dto.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.dto.UsuarioDto;
import oiasso.system.examples.security.entitys.UsuarioEntity;
import oiasso.system.examples.security.facades.UsuarioFacade;


@Component
public class UsuarioConversorDto extends AbstractConversorDto<UsuarioEntity, UsuarioDto > {

	@Autowired
	private UsuarioFacade usuarioFacade;
	
	@Autowired 
	private RolConversorDto rolConversorDto; 
	
	@Override
	public UsuarioEntity fromDto(UsuarioDto dto) {
		
		if(dto==null) {return null;}
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNombre(dto.getNombre());
		usuarioEntity.setContraseña(dto.getContraseña());
		usuarioEntity.setRoles(rolConversorDto.fromDto(dto.getRoles()));
		
		return usuarioEntity;
	}

	public UsuarioEntity fromDtoCreate(UsuarioDto dto) {
		
		if(dto==null) {return null;}
		
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		
		usuarioEntity.setNombre(dto.getNombre());
		usuarioEntity.setContraseña(dto.getContraseña());
		
		usuarioEntity.setRoles(rolConversorDto.fromDto(dto.getRoles()));
		
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
		
		usuarioEntity.setRoles(rolConversorDto.fromDto(dto.getRoles()));
		
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
		usuarioDto.setRoles(rolConversorDto.fromEntity(entity.getRoles()));
		
		return usuarioDto;
	}
	
	

}
