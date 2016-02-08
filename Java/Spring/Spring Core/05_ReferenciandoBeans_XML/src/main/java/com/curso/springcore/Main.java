package com.curso.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.springcore.beans.Persona;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/beans.xml");
		
		Persona persona1 = (Persona) applicationContext.getBean("personaAlias1");
		Persona persona2 = (Persona) applicationContext.getBean("personaName1");
		
		System.out.println(persona1.getId() + " - " + persona1.getNombre() + " - " + persona1.getApodo() + " - " + persona1.getPais().getNombre() + " - " + persona1.getPais().getCiudad().getNombre());
		System.out.println(persona2.getId() + " - " + persona2.getNombre() + " - " + persona2.getApodo() + " - " + persona2.getPais().getNombre() + " - " + persona2.getPais().getCiudad().getNombre());
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
