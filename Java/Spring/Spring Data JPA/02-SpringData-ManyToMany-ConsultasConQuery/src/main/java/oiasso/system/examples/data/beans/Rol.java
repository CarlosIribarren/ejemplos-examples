package oiasso.system.examples.data.beans;

import java.util.Collection;

public class Rol {
  
    private Long id;
 
    private String nombre;
    
    private Collection<Usuario> usuarios;
 
    private Collection<Privilegio> privilegios;

    
    
    
	public Rol(Long id, String nombre) {
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

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Collection<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}   
    
    
    
}
