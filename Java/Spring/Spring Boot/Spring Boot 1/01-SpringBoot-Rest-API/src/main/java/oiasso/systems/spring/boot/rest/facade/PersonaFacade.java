package oiasso.systems.spring.boot.rest.facade;

import java.util.List;

import oiasso.systems.spring.boot.rest.beans.Persona;

public interface PersonaFacade {

	public List<Persona> obtenerTodasLasPersonas(); 

	public Persona obtenerPersona(Integer id);
	
	public Persona crearPersona(Persona persona);

	public Integer borrarPersona(Integer id);

	public Persona actualizarPersona(Integer id, Persona persona);
	
}
