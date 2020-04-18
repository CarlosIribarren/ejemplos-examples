package oiasso.system.examples.data.facades.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.system.examples.data.beans.Usuario;
import oiasso.system.examples.data.daos.UsuarioDao;
import oiasso.system.examples.data.entitys.UsuarioEntity;
import oiasso.system.examples.data.facades.UsuarioFacade;

@Service
public class UsuarioFacadeImpl implements UsuarioFacade {

	@Autowired
	private UsuarioDao usuarioDao; 
	
	@Override
	public List<Usuario> findAll() {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		for(UsuarioEntity usuarioEntity : usuarioDao.findAll()) {
			Usuario u = new Usuario(usuarioEntity.getId(), usuarioEntity.getNombre(), usuarioEntity.getContraseña());
			usuarios.add(u);
		}
		
		return usuarios;
	}

}
