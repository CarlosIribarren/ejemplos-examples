
public class Circulo extends Figura {

	private Float radio;
	
	
	public Circulo( String nombre, Float radio) {
		super(nombre);
		this.radio = radio;
	}

	//POLIMORFISMO
	@Override
	public Float calcularArea() {
		// TODO Auto-generated method stub
		return (float)(Math.PI * Math.pow(radio, 2)) ;
	}


	@Override
	public String toString() {
		return super.toString() + "[radio=" + radio + "]";
	}
	
	

}
