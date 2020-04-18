package oiasso.system.examples.data.facades.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.system.examples.data.beans.Rol;
import oiasso.system.examples.data.beans.Usuario;
import oiasso.system.examples.data.daos.UsuarioDao;
import oiasso.system.examples.data.entitys.RolEntity;
import oiasso.system.examples.data.entitys.UsuarioEntity;
import oiasso.system.examples.data.facades.UsuarioFacade;

@Service
public class UsuarioFacadeImpl implements UsuarioFacade {

	@Autowired
	private UsuarioDao usuarioDao; 
	
	
	@Override
	public List<Usuario> findAllWithRoles() {
		List<Usuario> usuariosRespuesta = new ArrayList<>();
		
		for(UsuarioEntity usuarioEntity : usuarioDao.findAllWithRoles()) {
			
			// Obtener los roles de un usuario
			List<Rol> rolesRespuesta = new ArrayList<>();
			Collection<RolEntity> rolEntitys = usuarioEntity.getRoles();
			for(RolEntity rolEntity : rolEntitys ) {
				Rol rol = new Rol(rolEntity.getId(), rolEntity.getNombre());
				rolesRespuesta.add(rol);
			}
			
			Usuario u = new Usuario(usuarioEntity.getId(), usuarioEntity.getNombre(), usuarioEntity.getContraseña(), rolesRespuesta);
			usuariosRespuesta.add(u);
		}
		
		return usuariosRespuesta;
	}

}
