package oiasso.system.examples.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oiasso.system.examples.security.entitys.PrivilegioEntity;
import oiasso.system.examples.security.entitys.RolEntity;
import oiasso.system.examples.security.entitys.UsuarioEntity;
import oiasso.system.examples.security.repositories.PrivilegioRepository;
import oiasso.system.examples.security.repositories.RoleRepository;
import oiasso.system.examples.security.repositories.UsuarioRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
