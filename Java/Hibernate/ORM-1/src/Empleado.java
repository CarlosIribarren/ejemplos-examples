

import java.util.Date;

public class Empleado {

	private Integer idEmpleado;
	
	private String nombre;
	private Date fechaNacimiento;
	private Empleado jefe;
	private Coche coche;
	
	public Empleado getJefe() {
		return jefe;
	}


	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}


	public int getEdad()
	{
		return 0 ;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Coche getCoche() {
		return coche;
	}


	public void setCoche(Coche coche) {
		this.coche = coche;
	}


	public Integer getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	
	
}
