package my.project.dao;

import java.util.List;

import my.project.model.Empleado;

public interface EmpleadoDAO {
	public List<Empleado> findAll();
	public Empleado getById(String id);

}
