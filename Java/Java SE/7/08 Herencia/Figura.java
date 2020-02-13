
public abstract class Figura {

	String nombre;
	
	public Figura(String nombre){
		this.nombre = nombre;
	}
	//POLIMORFISMO
	public abstract Float calcularArea();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "figura : " + nombre;
	}
	
	
}
