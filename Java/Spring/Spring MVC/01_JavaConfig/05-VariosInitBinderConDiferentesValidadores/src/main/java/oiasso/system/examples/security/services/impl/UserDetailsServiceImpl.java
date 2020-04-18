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

import oiasso.system.examples.security.entitys.PrivilegioEntity;
import oiasso.system.examples.security.entitys.RolEntity;
import oiasso.system.examples.security.entitys.UsuarioEntity;
import oiasso.system.examples.security.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuarioEntity = usuarioRepository.findByNombre(username);
		
		if(usuarioEntity != null) {
			List<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
			
			// Añadir los roles y los privilegios
			for (RolEntity rolEntity : usuarioEntity.getRoles()) {
				grantedAuthoritys.add(new SimpleGrantedAuthority(rolEntity.getNombre()));
				for (PrivilegioEntity privilegioEntity : rolEntity.getPrivilegios()) {
					grantedAuthoritys.add(new SimpleGrantedAuthority(privilegioEntity.getNombre()));
				}
			}
			
			return new User(username, usuarioEntity.getContraseña(), grantedAuthoritys);
		} else {
			// En caso de no encontrar el usuario, se lanza la excepcion de usuario no encontrado, para que,
			// Spring security responda con la URL de /login?error
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
