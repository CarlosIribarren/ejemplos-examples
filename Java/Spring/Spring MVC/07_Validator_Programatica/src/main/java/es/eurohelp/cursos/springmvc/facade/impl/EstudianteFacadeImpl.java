package es.eurohelp.cursos.springmvc.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eurohelp.cursos.springmvc.beans.Estudiante;
import es.eurohelp.cursos.springmvc.dao.EstudianteDao;
import es.eurohelp.cursos.springmvc.facade.EstudianteFacade;

@Service
public class EstudianteFacadeImpl implements EstudianteFacade {

	@Autowired
	private EstudianteDao estudianteDAO;

	
	@Override
	public void Actualizar(Estudiante e) {
		estudianteDAO.Actualizar(e.getId(), e.getNombre(), e.getEmail(), e.getNif());
	}
	
	@Override
	public void Agregar(Estudiante e) {
		estudianteDAO.Agregar(e.getNombre(), e.getEmail(), e.getNif());
	}

	@Override
	public Estudiante getEstudiante(Integer id) {
		System.out.println("EstudianteFacadeImpl: procesando petición...");
		return estudianteDAO.getEstudiante(id);
	}

	@Override
	public List<Estudiante> listarEstudiantes() {
		return estudianteDAO.listarEstudiantes();
	}

	@Override
	public void Eliminar(Integer id) {
		estudianteDAO.Eliminar(id);
	}

}
