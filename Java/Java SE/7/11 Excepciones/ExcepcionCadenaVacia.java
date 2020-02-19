
// EJEMPLO DE EXCEPCION
// Para cada excepcion que se crea en java
// tenemos que definir una clase y en esa clase una sola excepcion.
// En la clase solo puede existir una excepcion.

public class ExcepcionCadenaVacia extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcepcionCadenaVacia(){
		super("Excepcion de cadena vacia");
	}
}
