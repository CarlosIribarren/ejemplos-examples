package principal;

import java.util.ArrayList;

public class Empresa {

	private String cif;
	private String nombre;
	private ArrayList<Empleado> empleados;
	private ArrayList<Coche> coches;
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	public ArrayList<Coche> getCoches() {
		return coches;
	}
	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}
	
	
	
	
}
