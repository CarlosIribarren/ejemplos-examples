package es.ibil.edinor.api.installationstudies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EdinorInstallationStudiesServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EdinorInstallationStudiesServiceApplication.class, args);
	}

}
