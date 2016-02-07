package com.curso.springcore.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * INFO:
 * 		- El nombre del metodo es el 'id' del Bean => <bean id="mundo"
 * 		- El Objeto de retorno del metodo es la clase sel Bean. => <bean class="Mundo"
 */
@Configuration
public class AppConfig {

	//  
	@Bean
	public Mundo mundo()
	{
		return new Mundo();
	}
	
}
