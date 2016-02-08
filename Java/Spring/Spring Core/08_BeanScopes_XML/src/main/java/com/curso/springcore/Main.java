package com.curso.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.springcore.beans.Ciudad;
import com.curso.springcore.beans.Persona;

public class Main {

	public static void main(String[] args) {
		
		// SINGLETON : LA MISMA INSTANCIA
		// PROTOTYPE : DIFERENTES INSTANCIAS
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/beans.xml");
		//***************** Objetos Singleton **************************
		Persona persona1 = (Persona) applicationContext.getBean("personaSINGLETON");
		Persona persona2 = (Persona) applicationContext.getBean("personaSINGLETON");
		
		/* 	Se le cambia el nombre al obj "persona1" y no se le cambia el nombre al obj "persona2"
			Lo normal es uno sea Juan y otro Jaime, pero no es asi, ya que, 
			como el Bean Persona esta definido como Singleton existe un solo obj en todo el sistema.
			Y los dos objetos son el mismo, entonces, tendran el mimso nombre. */	
			
		persona1.setNombre("Juan");
		System.out.println("******* Ejemplo con scope Singleton *************");
		System.out.println(persona1.getId() + " - " + persona1.getNombre() + " - " + persona1.getApodo() + " - " + persona1.getPais().getNombre() + " - " + persona1.getCiudad().getNombre());
		System.out.println(persona2.getId() + " - " + persona2.getNombre() + " - " + persona2.getApodo() + " - " + persona2.getPais().getNombre() + " - " + persona2.getCiudad().getNombre());
		
		//***************** Objetos Prototype **************************
		Persona persona3 = (Persona) applicationContext.getBean("personaPROTOTYPE");
		Persona persona4 = (Persona) applicationContext.getBean("personaPROTOTYPE");
		
		/* 	Se le cambia el nombre al obj "persona3" y no se le cambia el nombre al obj "persona4"
			Lo normal es uno sea Juan y otro Jaime, y es asi, ya que, 
			como el Bean Persona esta definido como Prototype existe una referencia para cada obj. */	
			
		persona3.setNombre("Juan");
		System.out.println("******* Ejemplo con scope Prototype *************");
		System.out.println(persona3.getId() + " - " + persona3.getNombre() + " - " + persona3.getApodo() + " - " + persona3.getPais().getNombre() + " - " + persona3.getCiudad().getNombre());
		System.out.println(persona4.getId() + " - " + persona4.getNombre() + " - " + persona4.getApodo() + " - " + persona4.getPais().getNombre() + " - " + persona4.getCiudad().getNombre());
				
		
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
