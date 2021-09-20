package oiasso.systems.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringEureka00HelloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEureka00HelloServiceApplication.class, args);
	}

}
