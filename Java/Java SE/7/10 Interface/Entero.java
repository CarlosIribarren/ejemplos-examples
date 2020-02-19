import Interfaces.IOperacion;


public class Entero implements IOperacion {

	private Double numero1;
	private Double numero2;
	
	
	public Entero(Double numero1, Double numero2) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	@Override
	public Double suma() {
		return numero1 + numero2;
	}

	@Override
	public Double resta() {
		return numero1 - numero2;
	}

	@Override
	public Double multiplicar() {
		return numero1 * numero2;
	}

}
