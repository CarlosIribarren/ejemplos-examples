package oiasso.system.examples.jpa.datatables.front;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTestConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
