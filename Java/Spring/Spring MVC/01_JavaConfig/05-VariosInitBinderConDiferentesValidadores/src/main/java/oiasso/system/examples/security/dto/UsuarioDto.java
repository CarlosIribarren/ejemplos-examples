package oiasso.system.examples.security.dto;

import java.util.Collection;

public class UsuarioDto {

	// ***********************
	// ****** Atributos ****** 
	// ***********************
	
	private String nombre;
	
	private String contraseña;

    private Collection<String> roles;


	// ***********************
	// ** Getters y Setters ** 
	// ***********************	    
    

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

	public Collection<String> getRoles() {
		return roles;
	}

	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}


	
}
