package oiasso.system.examples.security.listener;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.daos.PrivilegioDao;
import oiasso.system.examples.security.daos.RoleDao;
import oiasso.system.examples.security.daos.UsuarioDao;
import oiasso.system.examples.security.entitys.Privilegio;
import oiasso.system.examples.security.entitys.Rol;
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
 * 
 * Por defecto Sring Security espera que los roles empiecen por ROLE_
 */

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PrivilegioDao privilegioDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		

    	if(usuarioDao.findAll().isEmpty()) {

    		/********************************
    		 ************* USER *************
    		 ********************************/
    		
    		//Crear privilegio acceso-pantalla-principal
        	Privilegio privilegioAccesoPantallaPrincipal = new Privilegio();
        	privilegioAccesoPantallaPrincipal.setNombre("acceso-pantalla-principal");
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	privilegioAccesoPantallaPrincipal = privilegioDao.save(privilegioAccesoPantallaPrincipal);
    		
        	// Crear rol
        	Rol rolUser = new Rol();
        	rolUser.setNombre("ROLE_USER");
        	Collection<Privilegio> privilegiosUser = new ArrayList<>();
        	privilegiosUser.add(privilegioAccesoPantallaPrincipal);
        	rolUser.setPrivilegios(privilegiosUser);
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	rolUser = roleDao.save(rolUser);
        	
        	// Crear usuario
        	Usuario user = new Usuario();
        	user.setNombre("user");
        	user.setContraseña(bCryptPasswordEncoder.encode("user"));
        	Collection<Rol> rolesUser = new ArrayList<>();
        	rolesUser.add(rolUser);
        	user.setRoles(rolesUser);
        	usuarioDao.save(user);    		
    		
    		/********************************
    		 ************* ADMIN ************
    		 ********************************/        	
        	
    		//Crear privilegio acceso-gestion-usuarios
        	Privilegio privilegioAccesoGestionUsuarios = new Privilegio();
        	privilegioAccesoGestionUsuarios.setNombre("acceso-gestion-usuarios");
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	privilegioAccesoGestionUsuarios = privilegioDao.save(privilegioAccesoGestionUsuarios);        	

        	// Crear rol
        	Rol rolAdmin = new Rol();
        	rolAdmin.setNombre("ROLE_ADMIN");
        	Collection<Privilegio> privilegiosAdmin = new ArrayList<>();
        	privilegiosAdmin.add(privilegioAccesoPantallaPrincipal);
        	privilegiosAdmin.add(privilegioAccesoGestionUsuarios);
        	rolAdmin.setPrivilegios(privilegiosAdmin);
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	rolAdmin = roleDao.save(rolAdmin);
        	
        	// Crear usuario
        	Usuario admin = new Usuario();
        	admin.setNombre("admin");
        	admin.setContraseña(bCryptPasswordEncoder.encode("admin"));
        	Collection<Rol> rolesAdmin = new ArrayList<>();
        	rolesAdmin.add(rolAdmin);
        	rolesAdmin.add(rolUser);
        	admin.setRoles(rolesAdmin);
        	usuarioDao.save(admin);    		

    	}
    	

		
	}

}
