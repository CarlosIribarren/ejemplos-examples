package oiasso.systems.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringEureka00EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEureka00EurekaServiceApplication.class, args);
	}

}
