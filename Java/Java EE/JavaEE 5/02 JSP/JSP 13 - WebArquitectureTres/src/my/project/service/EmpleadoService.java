package my.project.service;

import java.util.List;

import my.project.model.Empleado;

public interface EmpleadoService {
	public List<Empleado> getEmpleados();
	public Empleado getEmpleadoByName(String name);

}
