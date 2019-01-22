package com.oiasso.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ExampleServletContextListener implements ServletContextListener {
	
        //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");	
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}
	
}
