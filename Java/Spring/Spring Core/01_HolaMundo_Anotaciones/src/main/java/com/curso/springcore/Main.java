package com.curso.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.springcore.beans.AppConfig;
import com.curso.springcore.beans.AppConfig2;
import com.curso.springcore.beans.Mundo;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class,AppConfig2.class);
		
		Mundo m1 = (Mundo) applicationContext.getBean("mundo");
		Mundo m2 = (Mundo) applicationContext.getBean("marte");
		
		System.out.println(m1.getSaludo());
		System.out.println(m2.getSaludo());
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

}
