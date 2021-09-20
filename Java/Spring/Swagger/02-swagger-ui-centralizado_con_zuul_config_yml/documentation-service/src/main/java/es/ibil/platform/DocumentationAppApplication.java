package es.ibil.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class DocumentationAppApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DocumentationAppApplication.class, args);
	}
	  
}
