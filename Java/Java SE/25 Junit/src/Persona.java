import java.util.LinkedList;


public class Persona {

	private String nombre;
	private LinkedList<Coche> coches;

	public Persona()
	{
		Coche c1 = new Coche("207");
		Coche c2 = new Coche("208");
		Coche c3 = new Coche("209");
		
		coches.add(c1);
		coches.add(c2);
		coches.add(c3);
	}
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(LinkedList<Coche> coches) {
		this.coches = coches;
	}
	
	
}
