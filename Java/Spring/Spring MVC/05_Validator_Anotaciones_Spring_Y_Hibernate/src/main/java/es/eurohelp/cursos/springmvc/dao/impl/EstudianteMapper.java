package es.eurohelp.cursos.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.eurohelp.cursos.springmvc.beans.Estudiante;


public class EstudianteMapper implements RowMapper<Estudiante> {

	public Estudiante mapRow(ResultSet rs, int arg1) throws SQLException {
		Estudiante student = new Estudiante();
	      student.setId(rs.getInt("id"));
	      student.setNombre(rs.getString("nombre"));
	      student.setEdad(rs.getInt("edad"));	      
		return student;
	}

	
}
