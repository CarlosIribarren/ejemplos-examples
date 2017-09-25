package principal;

public abstract class Vehiculo {

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
	
	
	
}
