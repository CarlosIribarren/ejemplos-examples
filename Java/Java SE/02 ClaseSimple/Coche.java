package EjemploClaseJava;


public class Coche {
	
	//ATRIBUTOS
	private String modelo;
	private String marca;
	private Integer potenciaMotor;
	private Boolean stado=false;
	
	//CONSTRUCTOR
	public Coche()
	{
		//constructor por defecto
		//llamar al objeto padre
		super();
		this.marca="peugeot";
		this.modelo= "207";
		this.potenciaMotor=100;
	}
	public Coche(String modelo, Integer power)
	{
		this.modelo=modelo;
		potenciaMotor=power;
	}
	public Coche(String marca , String modelo, Integer power)
	{
		this.marca=marca;
		this.modelo=modelo;
		this.potenciaMotor=power;
		
	}
	
	
	//Metodos
	public void encender()
	{
		this.stado=true;
	}
	public void apagar()
	{
		this.stado=false;
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
	public Integer getPotencia()
	{
		return this.potenciaMotor;
	}
	public void setpotenciaMotor(Integer potenciaMotor){
		this.potenciaMotor= potenciaMotor;
	}
	public String getStado()
	{
		if ( this.stado==false)
		{
			return "Apagado";
		}
		else
		{
			return "Encendido";
		}
		
				
	}
	public void setStado(Boolean stado){
		this.stado= stado;
	}
	@Override
	public String toString() {
		
		return "Coche [modelo=" + modelo + ", marca=" + marca
				+ ", potenciaMotor=" + potenciaMotor + ", stado=" + stado + "]";
	}
	
	
	
	
}



