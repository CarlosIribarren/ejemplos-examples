package oiasso.system.examples.formatter.dto;

import java.util.Collection;

public class UsuarioDto {

	// ***********************
	// ****** Atributos ****** 
	// ***********************
	
	private String nombre;
	
	private String contraseña;

    private Collection<RolDto> roles;


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

	public Collection<RolDto> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolDto> roles) {
		this.roles = roles;
	}


	
}
