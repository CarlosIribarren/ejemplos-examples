package com.innova4b.servicio.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.innova4b.servicio.ServicioEJB;

@Stateless
public class ServicioEJBImp implements ServicioEJB {
	//Definimos el contexto
	@Inject
	private JMSContext context;
	//Definimos el buzón (como está dentro del mismo servidor por inyección
	//si fuese externo sería con JNDI)
	@Resource(lookup = "java:/queue/JndiBuzonMDB")
	private Queue buzonCola;
	@Override
	public void enviarMensaje(String mensaje) {

		//Definimos un destino de tipo Queue
		final Destination destination = buzonCola;
		//Enviar mensaje del Servlet al buzón definido
		context.createProducer().send(destination, mensaje);
	}

}
