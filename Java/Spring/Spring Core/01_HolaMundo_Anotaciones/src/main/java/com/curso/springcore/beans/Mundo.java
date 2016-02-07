package com.curso.springcore.beans;

import org.springframework.beans.factory.annotation.Value;

public class Mundo {
	
	@Value("Hola Mundo utilizando la configuracion en una clase Java!!!")
	private String saludo;

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
	

}
