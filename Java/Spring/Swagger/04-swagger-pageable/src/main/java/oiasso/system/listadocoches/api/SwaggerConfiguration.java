package oiasso.system.listadocoches.api;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import oiasso.system.listadocoches.api.coche.swagger.SwaggerPageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket usersApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(usersApiInfo())
				.select()
				.paths(userPaths())
				.apis(RequestHandlerSelectors.any())
				.build()
				.directModelSubstitute(Pageable.class, SwaggerPageable.class);
	}

	private ApiInfo usersApiInfo() {
		return new ApiInfoBuilder()
				.version("1.0")
				.license("Oiasso Systems License")
				.build();
	}

	/** Especificar las URLs para documentar */
	private Predicate<String> userPaths() {
		return regex("/api.*");
	}

}
