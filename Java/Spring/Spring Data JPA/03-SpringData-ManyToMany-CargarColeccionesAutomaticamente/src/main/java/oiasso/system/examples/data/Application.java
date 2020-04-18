package oiasso.system.examples.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oiasso.system.examples.data.daos.PrivilegioDao;
import oiasso.system.examples.data.daos.RoleDao;
import oiasso.system.examples.data.daos.UsuarioDao;
import oiasso.system.examples.data.entitys.PrivilegioEntity;
import oiasso.system.examples.data.entitys.RolEntity;
import oiasso.system.examples.data.entitys.UsuarioEntity;

@SpringBootApplication
public class Application {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PrivilegioDao privilegioDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @PostConstruct
    public void init() {
    	
    	if(!usuarioDao.existsById(1)) {
        	
    		//Crear privilegio
        	PrivilegioEntity privilegioEntity = new PrivilegioEntity();
        	privilegioEntity.setNombre("acceso-pantalla-principal");
        	privilegioDao.save(privilegioEntity);

        	// Crear rol ADMIN
        	RolEntity rolEntity = new RolEntity();
        	rolEntity.setNombre("ROL_ADMIN");
        	Collection<PrivilegioEntity> privilegioEntities = new ArrayList<>();
        	privilegioEntities.add(privilegioDao.findByNombre("acceso-pantalla-principal"));
        	rolEntity.setPrivilegios(privilegioEntities);
        	roleDao.save(rolEntity);
        	
        	// Crear rol USER
        	RolEntity rolEntityUser = new RolEntity();
        	rolEntityUser.setNombre("ROL_USER");
        	rolEntityUser.setPrivilegios(privilegioEntities);
        	roleDao.save(rolEntityUser);        	
        	
        	// Crear usuario
        	UsuarioEntity admin = new UsuarioEntity();
        	admin.setId(1);
        	admin.setNombre("admin");
        	admin.setContraseña("admin");
        	Collection<RolEntity> roles = new ArrayList<>();
        	roles.add(roleDao.findByNombre("ROL_ADMIN"));
        	roles.add(roleDao.findByNombre("ROL_USER"));
        	admin.setRoles(roles);
        	usuarioDao.save(admin);    		

    	}
    	
    }
}
