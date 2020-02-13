package oiasso.system.listadocoches.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import oiasso.system.listadocoches.api.beans.Coche;

/**
 * Se configura para que retorne la primary key de la clase Coche.
 */

@Configuration
public class DataRestConfiguration implements WebMvcConfigurer, RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration) {
		configuration.setBasePath("/api");
		configuration.exposeIdsFor(Coche.class);
	}

}