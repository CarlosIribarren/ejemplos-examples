package com.innova4b.empresaReparto.persistent;


public class Coche extends Vehiculo {

	private Integer idVehiculo;
	
	
	private Empleado empleado;
	private Empresa empresa;
	
	@Override
	public Integer getNumeroPlazas() {
		return null;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	
	
}
