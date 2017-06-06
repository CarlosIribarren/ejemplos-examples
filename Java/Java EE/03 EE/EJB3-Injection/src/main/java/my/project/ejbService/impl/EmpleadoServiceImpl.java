package my.project.ejbService.impl;

import java.util.List;

import javax.ejb.Stateless;

import my.project.dao.EmpleadoDAO;
import my.project.dao.impl.EmpleadoDAOImpl;
import my.project.ejbService.EmpleadoService;
import my.project.model.Empleado;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoService{

	private EmpleadoDAO empleadoDAO;
	
	public EmpleadoServiceImpl() {
		this.empleadoDAO = new EmpleadoDAOImpl();
	}
	
	@Override
	public List<Empleado> getEmpleados() {
		// TODO Lógica de mi aplicación
		return empleadoDAO.findAll();
	}

	@Override
	public Empleado getEmpleadoByName(String name) {
		// TODO Lógica de mi aplicación
		return empleadoDAO.getById(name);
	}

}
