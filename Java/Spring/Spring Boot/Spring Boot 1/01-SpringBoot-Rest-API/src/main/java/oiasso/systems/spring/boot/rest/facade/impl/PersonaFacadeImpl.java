package oiasso.systems.spring.boot.rest.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oiasso.systems.spring.boot.rest.beans.Persona;
import oiasso.systems.spring.boot.rest.dao.PersonaDao;
import oiasso.systems.spring.boot.rest.facade.PersonaFacade;

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
