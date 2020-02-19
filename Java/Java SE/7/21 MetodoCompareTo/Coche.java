
public class Coche implements Comparable<Coche> {

	private String nombre;
	private Integer potencia;
	
	
	@Override
	public int compareTo(Coche c) {
		// utilizamos el operador this para hacer referencia al objeto que estamos
		// utilizamos c para hacer referencia al objeto que recibimos
		
		// return 0 si son iguales
		// return -1  si es menor
		// return 1  si es mayor
		int respuesta=0;
		
		if ( this.getPotencia() > c.getPotencia() )
		{
			respuesta= 1;
		}
		else if(this.getPotencia() < c.getPotencia())
		{
			respuesta= -1;
		}
		else if(this.getPotencia() == c.getPotencia())
		{
			respuesta= 0;
		}
		return respuesta;
		
	}
	
	
	public Coche(String nombre, Integer potencia) {
		super();
		this.nombre = nombre;
		this.potencia = potencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPotencia() {
		return potencia;
	}
	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	
}
