package oiasso.system.examples.jpa.datatables.facade.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oiasso.system.examples.jpa.datatables.beans.Persona;
import oiasso.system.examples.jpa.datatables.dao.PersonaDao;
import oiasso.system.examples.jpa.datatables.facade.PersonaFacade;

@Transactional
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
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public Persona obtenerPersona(Integer id) {
		// Retorna el objeto o si no lo encuentra retorna null
		return personaDao.findById(id).orElse(null);
	}

	@Override
	public Persona crearPersona(Persona persona) {
		return personaDao.save(persona);
	}

	@Override
	public void borrarPersona(Integer id) {
		personaDao.deleteById(id);
	}

	@Override
	public Persona actualizarPersona(Integer id, Persona persona) {
		if (id.equals(persona.getId())) {
			return personaDao.save(persona);
		} else {
			return null;
		}

	}

	@Override
	public Page<Persona> getAllPersona(Pageable pageable) {
		return personaDao.findAll(pageable);
	}

	@Override
	public List<Persona> buscarEntreDosId(Integer inicio, Integer fin) {
		return personaDao.findByIdBetween(inicio, fin);
	}

	@Override
	public List<Persona> buscarEntreDosFechas(LocalDate inicio, LocalDate fin) {
		return personaDao.findByFechaBetween(inicio, fin);
	}

}
