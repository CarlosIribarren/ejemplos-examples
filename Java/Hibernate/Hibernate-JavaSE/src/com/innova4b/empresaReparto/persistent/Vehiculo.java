package com.innova4b.empresaReparto.persistent;


public abstract class Vehiculo {

	private Integer idVehiculo;
	
	protected String matricula;
	protected int numeroPlazas;
	
	//METODOS ABSTRACTOS
	public abstract Integer getNumeroPlazas();
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setNumeroPlazas(Integer numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	
	
}
