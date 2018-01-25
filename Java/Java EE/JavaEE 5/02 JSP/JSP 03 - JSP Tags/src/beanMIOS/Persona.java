package beanMIOS;
import java.io.Serializable;


public class Persona implements Serializable {

	private static final long serialVersionUID = -3209741022632290719L;
	
	private String nombre;
	private String apellido;
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
