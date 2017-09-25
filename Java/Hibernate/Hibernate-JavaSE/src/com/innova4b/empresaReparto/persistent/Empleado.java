package com.innova4b.empresaReparto.persistent;


import java.util.Date;

public class Empleado {

	private Long idEmpleado;
	private String nombre;
	private Date fechaNacimiento;
	//private Empleado jefe;
	
	/*
	public Empleado getJefe() {
		return jefe;
	}


	public void setJefe(Empleado jefe) {
		this.jefe = jefe;
	}
	*/

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


	public Long getIdEmpleado() {
		return idEmpleado;
	}


	//PONEMOS EL METODO COMO PRIVADO, PARA QUE EL 
	// SISTEMA POR REFLEXION PUEDA ACCEDER A ESTABLECER EL ID
	
	//RAZON : NO SE PERMITE MODIFICAR EL ID
	//		  ATRIBUTO DE USO INTERNO
	private void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	
	
	
}
