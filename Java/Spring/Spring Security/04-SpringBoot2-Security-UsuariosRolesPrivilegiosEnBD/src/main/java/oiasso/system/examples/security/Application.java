package oiasso.system.examples.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oiasso.system.examples.security.daos.PrivilegioDao;
import oiasso.system.examples.security.daos.RoleDao;
import oiasso.system.examples.security.daos.UsuarioDao;
import oiasso.system.examples.security.entitys.Privilegio;
import oiasso.system.examples.security.entitys.Rol;
import oiasso.system.examples.security.entitys.Usuario;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
