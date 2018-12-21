package es.eurohelp.cursos.springmvc.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eurohelp.cursos.springmvc.dao.EstudianteDao;
import es.eurohelp.cursos.springmvc.facade.EstudianteFacade;
import es.eurohelp.cursos.springmvc.modelo.Estudiante;

@Service
public class EstudianteFacadeImpl implements EstudianteFacade {

	@Autowired
	private EstudianteDao estudianteDAO;
	
	@Override
	public void Agregar(String nombre, Integer edad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estudiante getEstudiante(Integer id) {
		System.out.println("EstudianteFacadeImpl: procesando petición...");
		return estudianteDAO.getEstudiante(id);
	}

	@Override
	public List<Estudiante> listarEstudiantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Actualizar(Integer id, Integer edad) {
		// TODO Auto-generated method stub
		
	}

}
