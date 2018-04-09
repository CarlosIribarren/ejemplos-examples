package es.eurohelp.cursos.springmvc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.eurohelp.cursos.springmvc.beans.Estudiante;
import es.eurohelp.cursos.springmvc.dao.EstudianteDao;

@Repository
public class EstudianteDAOImpl implements EstudianteDao {
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;   

	public void Agregar(String nombre, String  email, String nif) {
		  String SQL = "insert into estudiante2 (nombre, email, nif) values (?, ?, ?)";	      
		  jdbcTemplate.update( SQL, nombre,email, nif);
	      System.out.println("Registro creado nombre = " + nombre + " email = " + email);
	      return;
	}

	public Estudiante getEstudiante(Integer id) {
		System.out.println("EstudianteDAOImpl: procesando petición...");
		String SQL = "select * from estudiante2 where id = ?";
	    Estudiante student = jdbcTemplate.queryForObject(SQL, 
	                        new Object[]{id}, new EstudianteMapper());
	    return student;
	}

	public List<Estudiante> listarEstudiantes() {
		String SQL = "select * from estudiante2";
	      List <Estudiante> students = jdbcTemplate.query(SQL, 
	                                new EstudianteMapper());
	     return students;
	}

	public void Eliminar(Integer id) {
		 String SQL = "delete from estudiante2 where id = ?";
	      jdbcTemplate.update(SQL, id);
	      System.out.println("Registro eliminado ID = " + id );
	      return;
	}

	public void Actualizar(Integer id,String nombre,String  email, String nif) {
		
		  String SQL = "update estudiante2 set NOMBRE=?, email=?, nif=? where ID=?";
		  //Preparar los paramtros en el mismo orden
		  Object[] args = new Object[] {nombre, email,nif, id};
		  
		  try {
			  int rows = jdbcTemplate.update(SQL,args);
			  System.out.println("Registro [id="+ id +"] actualizado con exito ");
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro [id="+ id +"] por la causa : " + e.getMessage());
		}
	      
	      return;

	}	

}
