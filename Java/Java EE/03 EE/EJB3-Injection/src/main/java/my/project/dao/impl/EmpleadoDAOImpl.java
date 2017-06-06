package my.project.dao.impl;

import java.util.ArrayList;
import java.util.List;

import my.project.dao.EmpleadoDAO;
import my.project.model.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    
    public EmpleadoDAOImpl() { }
    
	@Override
	public List<Empleado> findAll() {
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		

		Empleado empleado1 = new Empleado();
		empleado1.setNombre("carlos1");
	
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("carlos2");
		
		Empleado empleado3 = new Empleado();
		empleado3.setNombre("carlos3");
		
		Empleado empleado4 = new Empleado();
		empleado4.setNombre("carlos4");
		
		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		empleados.add(empleado4);
		
		return empleados;
	}

	@Override
	public Empleado getById(String id) {
		
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("carlos1-por-busqueda :" + id);
	
		return empleado1;
	}

}
