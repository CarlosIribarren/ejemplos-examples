package oiasso.system.examples.data.facades.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.system.examples.data.daos.UsuarioDao;
import oiasso.system.examples.data.dtos.RolDTO;
import oiasso.system.examples.data.dtos.UsuarioDTO;
import oiasso.system.examples.data.entitys.RolEntity;
import oiasso.system.examples.data.entitys.UsuarioEntity;
import oiasso.system.examples.data.facades.UsuarioFacade;

@Service
public class UsuarioFacadeImpl implements UsuarioFacade {

	@Autowired
	private UsuarioDao usuarioDao; 
	
	
	@Override
	public List<UsuarioDTO> findAllWithRoles() {
		List<UsuarioDTO> usuariosRespuesta = new ArrayList<>();
		
		// Convertir Entitys -> DTOs
		for(UsuarioEntity usuarioEntity : usuarioDao.findAll()) {
			
			// Obtener los roles de un usuario
			List<RolDTO> rolesRespuesta = new ArrayList<>();
			Collection<RolEntity> rolEntitys = usuarioEntity.getRoles();
			for(RolEntity rolEntity : rolEntitys ) {
				RolDTO rolDTO = new RolDTO(rolEntity.getId(), rolEntity.getNombre());
				rolesRespuesta.add(rolDTO);
			}
			
			UsuarioDTO u = new UsuarioDTO(usuarioEntity.getId(), usuarioEntity.getNombre(), usuarioEntity.getContraseña(), rolesRespuesta);
			usuariosRespuesta.add(u);
		}
		
		return usuariosRespuesta;
	}

}
