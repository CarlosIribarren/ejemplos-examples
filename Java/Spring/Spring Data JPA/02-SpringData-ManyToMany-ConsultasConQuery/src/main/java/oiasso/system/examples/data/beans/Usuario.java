package oiasso.system.examples.data.beans;

import java.util.Collection;

public class Usuario {

	// ***********************
	// ****** Atributos ****** 
	// ***********************

	private Integer id;
	
	private String nombre;
	
	private String contraseña;

    private Collection<Rol> roles;

	// ***********************
	// ***** Constructor ***** 
	// ***********************		
	
	public Usuario(Integer id, String nombre, String contraseña, Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.roles = roles;
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

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}	
	
}
