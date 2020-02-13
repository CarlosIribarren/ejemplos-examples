package pakete;

public class CochePublico extends Coche{
	
	Persona conductor ;
	
	public CochePublico(  ){
		super();
		this.conductor = new Persona("carlos","iribarren");
	}

	public Persona getConductor() {
		return conductor;
	}

	public void setConductor(Persona conductor) {
		this.conductor = conductor;
	}
	
	

}

