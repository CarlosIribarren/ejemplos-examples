package oiasso.system.examples.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.daos.UsuarioDao;
import oiasso.system.examples.security.entitys.Usuario;

/**
 * La primera vez se insertan los usuarios admin y user.
 * El password se guarda en la BD encriptado. (Ejemplo de admin: $2a$10$SUSDaYLh8Z3O/aZxpe9fGO83sItnUvjqigqnV9YsvGlY1QByZ/ln6)
 * El password se guarda encriptado, porque, se ha configurado que los passwords en la BD estan encriptados. 
 * 
 * Entonces cuando un usuario hace login, en el service UserDetailsServiceImpl se obtiene el usuario de la BD y se retorna como un User de Spring Security.
 * Con ese usuario que se retorna de esa clase, Spring Security automaticamente desencriptara el password para compararlo con el password introducido por el usuario.
 * Y asi de esta manera concuerdan los password.
 * Si hicieramos un CRUD, al insertar un usuario nuevo, tendriamos que encriptar el password de la misma manera.   
 */

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
    	if(!usuarioDao.existsById(1)) {
        	Usuario admin = new Usuario();
        	admin.setId(1);
        	admin.setUsername("admin");
        	admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        	usuarioDao.save(admin);    		
    	}
		
    	if(!usuarioDao.existsById(2)) {
        	Usuario user = new Usuario();
        	user.setId(2);
        	user.setUsername("user");
        	user.setPassword(bCryptPasswordEncoder.encode("user"));
        	usuarioDao.save(user);    		
    	}    	
    	
	}

}
