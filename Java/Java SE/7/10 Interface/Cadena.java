import Interfaces.IMostrar;
import Interfaces.IOperacion;

// Herencia múltiple :
// En este ejemplo se observa como una clase implementa ( hereda )
// de dos clases.


public class Cadena implements IOperacion, IMostrar {

	private String texto1;
	private String texto2;
	
	
	
	public Cadena(String texto1, String texto2) {
		super();
		this.texto1 = texto1;
		this.texto2 = texto2;
	}

	@Override
	public String suma() {
		return texto1+texto2;
	}

	@Override
	public String resta() {
		return texto1 + "restado";
	}

	@Override
	public String multiplicar() {
		return texto1 + "multiplicado";
	}

	@Override
	public String mostrar() {
		return "mostrando " + texto1 + texto2;
	}

}
