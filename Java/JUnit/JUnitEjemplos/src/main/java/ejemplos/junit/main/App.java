/*
 * Copyright (c) 2017, Gipuzkoako Foru Aldundia
 * Eskubide guztiak erreserbatuta / All rights reserved
 */
package ejemplos.junit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ejemplos.junit.config.AppConfig;
import ejemplos.junit.facades.UsuarioFacade;


public class App {
  public static void main(final String[] args) {

    // Cargar el contexto con fichero XML
    // final ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

    // Cargar el contexto con JavaConfig
    final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // Obtener el Bean con la anotacion de @Service
    final UsuarioFacade usuarioFacade = (UsuarioFacade) context.getBean("usuarioFacadeImpl");

    usuarioFacade.holaMundoJUnitAndMock(1);

  }
}
