package oiasso.systems.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ExampleServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ExampleServiceApplication.class, args);
	}

}
