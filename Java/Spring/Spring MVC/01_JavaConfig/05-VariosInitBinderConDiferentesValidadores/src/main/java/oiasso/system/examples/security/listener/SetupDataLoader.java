package oiasso.system.examples.security.listener;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import oiasso.system.examples.security.entitys.PrivilegioEntity;
import oiasso.system.examples.security.entitys.RolEntity;
import oiasso.system.examples.security.entitys.UsuarioEntity;
import oiasso.system.examples.security.repositories.PrivilegioRepository;
import oiasso.system.examples.security.repositories.RoleRepository;
import oiasso.system.examples.security.repositories.UsuarioRepository;

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
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegioRepository privilegioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		

    	if(usuarioRepository.findAll().isEmpty()) {

    		/********************************
    		 ************* USER *************
    		 ********************************/
    		
    		//Crear privilegio acceso-pantalla-principal
        	PrivilegioEntity privilegioAccesoPantallaPrincipal = new PrivilegioEntity();
        	privilegioAccesoPantallaPrincipal.setNombre("acceso-pantalla-principal");
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	privilegioAccesoPantallaPrincipal = privilegioRepository.save(privilegioAccesoPantallaPrincipal);
    		
        	// Crear rol
        	RolEntity rolUser = new RolEntity();
        	rolUser.setNombre("ROLE_USER");
        	Collection<PrivilegioEntity> privilegiosUser = new ArrayList<>();
        	privilegiosUser.add(privilegioAccesoPantallaPrincipal);
        	rolUser.setPrivilegios(privilegiosUser);
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	rolUser = roleRepository.save(rolUser);
        	
        	// Crear usuario
        	UsuarioEntity user = new UsuarioEntity();
        	user.setNombre("user");
        	user.setContraseña(bCryptPasswordEncoder.encode("user"));
        	Collection<RolEntity> rolesUser = new ArrayList<>();
        	rolesUser.add(rolUser);
        	user.setRoles(rolesUser);
        	usuarioRepository.save(user);    		
    		
    		/********************************
    		 ************* ADMIN ************
    		 ********************************/        	
        	
    		//Crear privilegio acceso-gestion-usuarios
        	PrivilegioEntity privilegioAccesoGestionUsuarios = new PrivilegioEntity();
        	privilegioAccesoGestionUsuarios.setNombre("acceso-gestion-usuarios");
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	privilegioAccesoGestionUsuarios = privilegioRepository.save(privilegioAccesoGestionUsuarios);        	

        	// Crear rol
        	RolEntity rolAdmin = new RolEntity();
        	rolAdmin.setNombre("ROLE_ADMIN");
        	Collection<PrivilegioEntity> privilegiosAdmin = new ArrayList<>();
        	privilegiosAdmin.add(privilegioAccesoPantallaPrincipal);
        	privilegiosAdmin.add(privilegioAccesoGestionUsuarios);
        	rolAdmin.setPrivilegios(privilegiosAdmin);
        	// Se guarda el objeto y se recupera el guardado en BD que ya tiene el id, ya que el id esta definido como autonumerico
        	rolAdmin = roleRepository.save(rolAdmin);
        	
        	// Crear usuario
        	UsuarioEntity admin = new UsuarioEntity();
        	admin.setNombre("admin");
        	admin.setContraseña(bCryptPasswordEncoder.encode("admin"));
        	Collection<RolEntity> rolesAdmin = new ArrayList<>();
        	rolesAdmin.add(rolAdmin);
        	rolesAdmin.add(rolUser);
        	admin.setRoles(rolesAdmin);
        	usuarioRepository.save(admin);    		

    	}
    	

		
	}

}
