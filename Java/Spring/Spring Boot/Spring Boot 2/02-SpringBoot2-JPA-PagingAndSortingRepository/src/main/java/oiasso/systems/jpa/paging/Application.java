package oiasso.systems.jpa.paging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * This is the main Spring Boot application class. It configures Spring Boot, JPA
 */

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "oiasso.systems.jpa.paging")
@EnableJpaRepositories("oiasso.systems.jpa.paging.dao")
public class Application {

	private static final Class<Application> applicationClass = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

}
