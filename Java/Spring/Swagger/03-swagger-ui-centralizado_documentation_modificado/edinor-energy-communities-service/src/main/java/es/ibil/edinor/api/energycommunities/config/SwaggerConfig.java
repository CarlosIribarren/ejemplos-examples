package es.ibil.edinor.api.energycommunities.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class})
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private final ServletContext servletContext;
	
	@Autowired
	private BuildProperties buildProperties;
	
    @Autowired
    public SwaggerConfig(final ServletContext servletContext) {
        this.servletContext = servletContext;
    }
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			    .pathProvider(new RelativePathProvider(servletContext) {
			        @Override
			        public String getApplicationBasePath() {
			            return "/api/energy-communities";
			        }
			    })
				.apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(Predicates.not(PathSelectors.regex("/error.*")))
	            .build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(buildProperties.getName())
				.version(buildProperties.getVersion())
				.build();
	}
	
	
}
