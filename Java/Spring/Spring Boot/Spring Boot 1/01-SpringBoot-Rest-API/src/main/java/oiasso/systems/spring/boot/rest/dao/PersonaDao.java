package oiasso.systems.spring.boot.rest.dao;

import java.util.List;

import oiasso.systems.spring.boot.rest.beans.Persona;

public interface PersonaDao {

	public List<Persona> obtenerTodasLasPersonas();

	public Persona obtenerPersona(Integer id);

	public Persona crearPersona(Persona Persona);

	public Integer borrarPersona(Integer id);

	public Persona actualizarPersona(Integer id, Persona Persona);

}
