package com.curso.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.springcore.beans.Mundo;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/beans.xml");
		
		Mundo m1 = (Mundo) applicationContext.getBean("mundo");
		Mundo m2 = (Mundo) applicationContext.getBean(Mundo.class);
		
		System.out.println(m1.getSaludo());
		System.out.println(m2.getSaludo());
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
