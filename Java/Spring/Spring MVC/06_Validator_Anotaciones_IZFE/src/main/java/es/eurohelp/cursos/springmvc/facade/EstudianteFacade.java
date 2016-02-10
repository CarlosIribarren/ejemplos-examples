package es.eurohelp.cursos.springmvc.facade;

import java.util.List;

import es.eurohelp.cursos.springmvc.beans.Estudiante;

public interface EstudianteFacade {
	
	public void Agregar(Estudiante e);
	public Estudiante getEstudiante(Integer id);
	public List<Estudiante> listarEstudiantes();
	public void Eliminar(Integer id);
	public void Actualizar(Estudiante e);

}
