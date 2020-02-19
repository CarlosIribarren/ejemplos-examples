package oiasso.system.examples.jpa.datatables.back;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import oiasso.system.examples.jpa.datatables.back.beans.Persona;

/**
 * Se configura para que retorne el id de la clase Persona. Se configura la url
 * para exponer los API.
 *
 */

@Configuration
public class RestConfiguration implements WebMvcConfigurer, RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration) {
		configuration.setBasePath("/api");
		configuration.exposeIdsFor(Persona.class);
	}

}