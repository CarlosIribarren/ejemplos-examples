package com.curso.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.springcore.beans.Ciudad;
import com.curso.springcore.beans.Persona;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/beans.xml");
		
		Persona persona1 = (Persona) applicationContext.getBean("persona");
		
		
		System.out.println(persona1.getId() + " - " + persona1.getNombre() + " - " + persona1.getApodo() + " - " + persona1.getPais().getNombre() + " - " + persona1.getCiudad().getNombre());
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
