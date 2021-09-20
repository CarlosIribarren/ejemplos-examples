package es.ibil.edinor.api.energycommunities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EdinorEnergyCommunitiesServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EdinorEnergyCommunitiesServiceApplication.class, args);
	}

}
