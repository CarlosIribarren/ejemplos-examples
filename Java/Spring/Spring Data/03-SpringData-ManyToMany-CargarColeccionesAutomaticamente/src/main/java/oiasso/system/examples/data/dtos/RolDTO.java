package oiasso.system.examples.data.dtos;

import java.util.Collection;

public class RolDTO {
  
    private Long id;
 
    private String nombre;
    
    private Collection<UsuarioDTO> usuarioDTOs;
 
    private Collection<PrivilegioDTO> privilegioDTOs;

    
    
    
	public RolDTO(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

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

	public Collection<UsuarioDTO> getUsuarios() {
		return usuarioDTOs;
	}

	public void setUsuarios(Collection<UsuarioDTO> usuarioDTOs) {
		this.usuarioDTOs = usuarioDTOs;
	}

	public Collection<PrivilegioDTO> getPrivilegios() {
		return privilegioDTOs;
	}

	public void setPrivilegios(Collection<PrivilegioDTO> privilegioDTOs) {
		this.privilegioDTOs = privilegioDTOs;
	}   
    
    
    
}
