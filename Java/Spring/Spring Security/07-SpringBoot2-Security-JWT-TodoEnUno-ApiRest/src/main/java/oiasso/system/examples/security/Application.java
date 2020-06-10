package oiasso.system.examples.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oiasso.system.examples.security.daos.UsuarioDao;
import oiasso.system.examples.security.entitys.Usuario;

@SpringBootApplication
public class Application {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	/**
	 * La primera vez se inserta el usuario admin.
	 * El password se guarda en la BD encriptado. (Ejemplo de admin: $2a$10$SUSDaYLh8Z3O/aZxpe9fGO83sItnUvjqigqnV9YsvGlY1QByZ/ln6)
	 * El password se guarda encriptado, porque, se ha configurado que los passwords en la BD estan encriptados. 
	 * 
	 * Entonces cuando un usuario hace login, en el service UserDetailsServiceImpl se obtiene el usuario de la BD y se retorna como un User de Spring Security.
	 * Con ese usuario que se retorna de esa clase, Spring Security automaticamente desencriptara el password para compararlo con el password introducido por el usuario.
	 * Y asi de esta manera concuerdan los password.
	 * Si hicieramos un CRUD, al insertar un usuario nuevo, tendriamos que encriptar el password de la misma manera.   
	 */
    @PostConstruct
    public void init() {
    	
    	if(!usuarioDao.existsById(1)) {
    		
        	Usuario admin = new Usuario();
        	admin.setId(1);
        	admin.setUsername("admin");
        	admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        	
        	usuarioDao.save(admin);    		
    		
    	}
    	

    }
}
