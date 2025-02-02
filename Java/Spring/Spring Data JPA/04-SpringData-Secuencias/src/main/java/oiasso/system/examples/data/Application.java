package oiasso.system.examples.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oiasso.system.examples.data.daos.UsuarioDao;
import oiasso.system.examples.data.entitys.UsuarioEntity;

@SpringBootApplication
public class Application {

	@Autowired
	private UsuarioDao usuarioDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @PostConstruct
    public void init() {
    	
    	if(usuarioDao.findAll().isEmpty()) {
        	
        	// Crear usuario
        	UsuarioEntity admin = new UsuarioEntity();
        	admin.setNombre("admin");
        	admin.setContraseña("admin");
        	UsuarioEntity usuarioBd = usuarioDao.save(admin);    		

    	}
    	
    }
}
