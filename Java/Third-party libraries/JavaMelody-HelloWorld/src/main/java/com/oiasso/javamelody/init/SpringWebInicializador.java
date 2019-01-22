package com.oiasso.javamelody.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.oiasso.javamelody.config.ConfiguracionSpring;

public class SpringWebInicializador implements WebApplicationInitializer {
	 
    public void onStartup(ServletContext contenedor) throws ServletException {
 
     
        AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
        // Registrar contexto
        contexto.register(ConfiguracionSpring.class);
        contexto.setServletContext(contenedor);
 
        ServletRegistration.Dynamic servlet = contenedor.addServlet("dispatcher", new DispatcherServlet(contexto));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        
    }
 
}
