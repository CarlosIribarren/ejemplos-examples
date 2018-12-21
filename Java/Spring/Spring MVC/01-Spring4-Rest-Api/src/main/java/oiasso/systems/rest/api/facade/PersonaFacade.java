package oiasso.systems.rest.api.facade;

import java.util.List;

import oiasso.systems.rest.api.model.Persona;

public interface PersonaFacade {

	public List<Persona> obtenerTodasLasPersonas(); 

	public Persona obtenerPersona(Integer id);
	
	public Persona crearPersona(Persona persona);

	public Integer borrarPersona(Integer id);

	public Persona actualizarPersona(Integer id, Persona persona);
	
}
