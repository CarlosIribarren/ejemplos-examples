package oiasso.systems.docs;

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

	public static void main(String[] args) {
		SpringApplication.run(DocumentationAppApplication.class, args);
	}
	
	
//	  @Bean
//	  public WebMvcConfigurer corsConfigurer() {
//	    return new WebMvcConfigurer() {
//	      @Override
//	      public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**").allowedOrigins("*");
//	      }
//	    };
//	  }
	  
	  
}
