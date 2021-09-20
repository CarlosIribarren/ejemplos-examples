package oiasso.systems.docs.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/*
	 * Es necesario permitir llamadas CORS para que cuando desde el swager-ui central (principal), es decir, 
	 * el que contien a todos los mircroservicios, se pruebe la API (los metodos), y se hagan llamadas desde un origen que no es el suyo.
	 * Es decir, un ejemplo, se realizan llamadas desde el swager-ui general en el puerto 9093, al microservicio de personas que esta en el puerto 9091.
	 * documentation-app:9093 --->>> employee-application:9091 (este)
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
	
}
