package oiasso.system.examples.data.dtos;

import java.util.Collection;

public class UsuarioDTO {

	// ***********************
	// ****** Atributos ****** 
	// ***********************

	private Integer id;
	
	private String nombre;
	
	private String contraseña;

    private Collection<RolDTO> roles;

	// ***********************
	// ***** Constructor ***** 
	// ***********************		
	
	public UsuarioDTO(Integer id, String nombre, String contraseña, Collection<RolDTO> roles) {
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

	public Collection<RolDTO> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolDTO> roles) {
		this.roles = roles;
	}	
	
}
