package oiasso.system.examples.jpa.datatables.back;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JpaConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("prueba");
		dataSource.setPassword("prueba");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/prueba");
		return dataSource;
	}

}
