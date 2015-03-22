public class Coche {
	
	//ATRIBUTOS
	private String modelo;
	private String marca;

	
	//CONSTRUCTOR
	public Coche()
	{
		//constructor por defecto
		//llamar al objeto padre
		super();
		this.marca="peugeot";
		this.modelo= "207";
	}
	public Coche(String modelo)
	{
		this.modelo=modelo;
	}
	public Coche(String marca , String modelo)
	{
		this.marca=marca;
		this.modelo=modelo;
		
	}
	
	//Getter y Setter
	public String getModelo()
	{
		return this.modelo;
	}
	public void setModelo(String modelo){
		this.modelo= modelo;
	}
	public String getMarca()
	{
		return this.marca;
	}
	public void setMarca(String marca){
		this.marca= marca;
	}

	
	
	
	
}



