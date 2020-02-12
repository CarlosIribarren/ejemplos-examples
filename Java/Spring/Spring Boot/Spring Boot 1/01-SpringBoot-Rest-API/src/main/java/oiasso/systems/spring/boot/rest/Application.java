package oiasso.systems.spring.boot.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/*
 * This is the main Spring Boot application class. It configures Spring Boot, JPA
 */

@SpringBootApplication
@ComponentScan(basePackages = "oiasso.systems.spring.boot.rest")
public class Application extends SpringBootServletInitializer {

	private static final Class<Application> applicationClass = Application.class;

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

}
