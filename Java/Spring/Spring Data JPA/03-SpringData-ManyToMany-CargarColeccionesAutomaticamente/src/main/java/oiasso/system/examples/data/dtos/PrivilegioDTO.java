package oiasso.system.examples.data.dtos;

import java.util.Collection;

public class PrivilegioDTO {
  
    private Long id;
 
    private String nombre;
 
    private Collection<RolDTO> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<RolDTO> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolDTO> roles) {
		this.roles = roles;
	}
    
    
    
}
