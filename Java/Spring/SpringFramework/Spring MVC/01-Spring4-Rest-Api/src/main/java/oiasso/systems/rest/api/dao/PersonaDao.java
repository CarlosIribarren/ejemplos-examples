package oiasso.systems.rest.api.dao;

import java.util.List;

import oiasso.systems.rest.api.model.Persona;

public interface PersonaDao {

	public List<Persona> obtenerTodasLasPersonas(); 

	public Persona obtenerPersona(Integer id);
	
	public Persona crearPersona(Persona Persona);

	public Integer borrarPersona(Integer id);

	public Persona actualizarPersona(Integer id, Persona Persona);
	
}
