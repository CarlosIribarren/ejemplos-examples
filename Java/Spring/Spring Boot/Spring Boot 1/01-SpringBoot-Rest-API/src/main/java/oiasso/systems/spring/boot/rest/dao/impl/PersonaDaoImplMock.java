package oiasso.systems.spring.boot.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import oiasso.systems.spring.boot.rest.beans.Persona;
import oiasso.systems.spring.boot.rest.dao.PersonaDao;

@Repository
public class PersonaDaoImplMock implements PersonaDao {

	// *********************
	// ***** Atributos *****
	// *********************
	
	/** Mock de listado de personas */
	private List<Persona> personas;

	// *********************
	// **** Constructor ****
	// *********************
	
	public PersonaDaoImplMock() {
		super();
		personas = new ArrayList<>();
		personas.add(new Persona(1, "Juan", "Perez"));
		personas.add(new Persona(2, "Jose", "Etxeberria"));
		personas.add(new Persona(3, "Jon", "Smith"));
	}	
	
	// *******************************
	// **** Metodos implementados ****
	// *******************************
	
	@Override
	public List<Persona> obtenerTodasLasPersonas() {
		return personas;
	}

	@Override
	public Persona obtenerPersona(Integer id) {
		for (Persona persona : personas) {
			if (persona.getId().equals(id)) {
				return persona;
			}
		}
		return null;
	}

	@Override
	public Persona crearPersona(Persona personaNueva) {
		
		//Obtener el ultimo + 1
		Persona persona = personas.get(personas.size()-1);
		Integer ultimoId = persona.getId();
		Integer nuevoId = ultimoId + 1;
		
		// Crear persona
		personaNueva.setId(nuevoId);
		personas.add(personaNueva);
		return personaNueva;
	}

	@Override
	public Integer borrarPersona(Integer id) {
		for (Persona persona : personas) {
			if (persona.getId().equals(id)) {
				personas.remove(persona);
				return id;
			}
		}
		return null;
	}

	@Override
	public Persona actualizarPersona(Integer id, Persona personaModificada) {
		for (Persona persona : personas) {
			if (persona.getId().equals(id)) {
				persona.setNombre(personaModificada.getNombre());
				persona.setApellido(personaModificada.getApellido());
				return persona;
			}
		}

		return null;
	}

}
