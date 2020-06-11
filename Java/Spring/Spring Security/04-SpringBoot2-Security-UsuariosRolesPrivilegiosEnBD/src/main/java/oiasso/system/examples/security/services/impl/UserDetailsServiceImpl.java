package oiasso.system.examples.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import oiasso.system.examples.security.daos.UsuarioDao;
import oiasso.system.examples.security.entitys.Privilegio;
import oiasso.system.examples.security.entitys.Rol;
import oiasso.system.examples.security.entitys.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByNombre(username);
		
		if(usuario != null) {
			List<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
			
			// Añadir los roles y los privilegios
			for (Rol rol : usuario.getRoles()) {
				grantedAuthoritys.add(new SimpleGrantedAuthority(rol.getNombre()));
				for (Privilegio privilegio : rol.getPrivilegios()) {
					grantedAuthoritys.add(new SimpleGrantedAuthority(privilegio.getNombre()));
				}
			}
			
			return new User(username, usuario.getContraseña(), grantedAuthoritys);
		} else {
			// En caso de no encontrar el usuario, se lanza la excepcion de usuario no encontrado, para que,
			// Spring security responda con la URL de /login?error
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
