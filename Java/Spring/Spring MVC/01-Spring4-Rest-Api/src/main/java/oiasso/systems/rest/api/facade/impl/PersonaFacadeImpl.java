package oiasso.systems.rest.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.rest.api.dao.PersonaDao;
import oiasso.systems.rest.api.facade.PersonaFacade;
import oiasso.systems.rest.api.model.Persona;

@Service
public class PersonaFacadeImpl implements PersonaFacade {

	// *********************
	// ***** Atributos *****
	// *********************
		
	@Autowired
	private PersonaDao personaDao;
	
	// *********************
	// **** Constructor ****
	// *********************
	
	public PersonaFacadeImpl() {
		super();
	}

	// *******************************
	// **** Metodos implementados ****
	// *******************************
	
	@Override
	public List<Persona> obtenerTodasLasPersonas() {
		return personaDao.obtenerTodasLasPersonas();
	}

	@Override
	public Persona obtenerPersona(Integer id) {
		return personaDao.obtenerPersona(id);
	}

	@Override
	public Persona crearPersona(Persona persona) {
		return personaDao.crearPersona(persona);
	}

	@Override
	public Integer borrarPersona(Integer id) {
		return personaDao.borrarPersona(id);
	}

	@Override
	public Persona actualizarPersona(Integer id, Persona persona) {
		return personaDao.actualizarPersona(id, persona);
	}

}
