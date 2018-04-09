

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//crear una empresa
		Empresa e = new Empresa();
		
		e.setNombre("Innova4B");
		e.setCif("ASDFA");
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		Date fecha = new Date();
		
		//empleado 1
		Empleado em1 = new Empleado();
		em1.setNombre("Carlos");
		em1.setFechaNacimiento(fecha);
		
		//empleado2
		Empleado em2 = new Empleado();
		em2.setNombre("David");
		em2.setFechaNacimiento(fecha);
		
		//empleado3
		Empleado em3 = new Empleado();
		em3.setNombre("Jesus");
		em3.setFechaNacimiento(fecha);
		
		
		
		
		
		
		
		
		
		
		e.setEmpleados(empleados);

	}

}
