package oiasso.systems.elastic.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "oiasso.systems.elastic.example")
public class Config {
	
	@Bean
	public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(30000);
        factory.setReadTimeout(90000);
        return new RestTemplate(factory);
	}
	
}
