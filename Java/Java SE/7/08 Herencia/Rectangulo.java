
public class Rectangulo extends Figura {

	private Float height;
	private Float width;
	
	
	public Rectangulo(String nombre, Float height, Float width) {
		super(nombre);
		this.height = height;
		this.width = width;
	}

	//POLIMORFISMO
	@Override
	public Float calcularArea() {
		return height*width;
	}


	@Override
	public String toString() {
		return super.toString() + " [height=" + height + ", width=" + width + "]";
	}

	 

	

}
