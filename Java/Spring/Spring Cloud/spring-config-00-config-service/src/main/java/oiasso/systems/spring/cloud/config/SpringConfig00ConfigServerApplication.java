package oiasso.systems.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringConfig00ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfig00ConfigServerApplication.class, args);
	}

}
 