package my.project.ejbService;

import java.util.List;

import javax.ejb.Local;

import my.project.model.Empleado;

@Local
public interface EmpleadoService {
	public List<Empleado> getEmpleados();
	public Empleado getEmpleadoByName(String name);

}
