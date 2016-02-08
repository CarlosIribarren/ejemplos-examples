package es.eurohelp.cursos.springmvc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.eurohelp.cursos.springmvc.dao.EstudianteDao;
import es.eurohelp.cursos.springmvc.modelo.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDao {
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;   

	public void Agregar(String nombre, Integer edad) {
		  String SQL = "insert into estudiante (nombre, edad) values (?, ?)";	      
		  jdbcTemplate.update( SQL, nombre,edad);
	      System.out.println("Registro creado nombre = " + nombre + " edad = " + edad);
	      return;
	}

	public Estudiante getEstudiante(Integer id) {
		System.out.println("EstudianteDAOImpl: procesando petición...");
		String SQL = "select * from estudiante where id = ?";
	    Estudiante student = jdbcTemplate.queryForObject(SQL, 
	                        new Object[]{id}, new EstudianteMapper());
	    return student;
	}

	public List<Estudiante> listarEstudiantes() {
		String SQL = "select * from estudiante";
	      List <Estudiante> students = jdbcTemplate.query(SQL, 
	                                new EstudianteMapper());
	     return students;
	}

	public void Eliminar(Integer id) {
		 String SQL = "delete from estudiante where id = ?";
	      jdbcTemplate.update(SQL, id);
	      System.out.println("Registro eliminado ID = " + id );
	      return;
	}

	public void Actualizar(Integer id, Integer edad) {
		  String SQL = "update estudiante set edad = ? where id = ?";
	      jdbcTemplate.update(SQL, edad, id);
	      System.out.println("registro actualizado  ID = " + id );
	      return;

	}	

}
