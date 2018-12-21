package es.eurohelp.cursos.springmvc.facade;

import java.util.List;

import es.eurohelp.cursos.springmvc.modelo.Estudiante;

public interface EstudianteFacade {
	
	public void Agregar(String nombre, Integer edad);
	public Estudiante getEstudiante(Integer id);
	public List<Estudiante> listarEstudiantes();
	public void Eliminar(Integer id);
	public void Actualizar(Integer id, Integer edad);

}
