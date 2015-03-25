package Bean;

import java.io.Serializable;

public class PersonaBean implements Serializable {

	private static final long serialVersionUID = 5808143714681482251L;

	private String nombre;
	private String apellido;
	
	public PersonaBean() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
