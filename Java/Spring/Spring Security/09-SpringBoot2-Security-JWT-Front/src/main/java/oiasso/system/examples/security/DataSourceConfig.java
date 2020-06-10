package oiasso.system.examples.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/db_pruebas");
		dataSource.setSchema("schema_pruebas");
		dataSource.setUsername("username_pruebas");
		dataSource.setPassword("password_pruebas");		
		return dataSource;
	}

}
