package oiasso.system.examples.data.beans;

public class Usuario {

	// ***********************
	// ****** Atributos ****** 
	// ***********************

	private Integer id;
	
	private String nombre;
	
	private String contraseña;

	// ***********************
	// ***** Constructor ***** 
	// ***********************		
	
	public Usuario(Integer id, String nombre, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	// ***********************
	// ** Getters y Setters ** 
	// ***********************	    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
