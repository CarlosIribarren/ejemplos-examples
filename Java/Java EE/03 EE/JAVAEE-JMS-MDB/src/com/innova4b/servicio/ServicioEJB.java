package com.innova4b.servicio;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
public interface ServicioEJB {
	public void enviarMensaje (String mensaje);
}
