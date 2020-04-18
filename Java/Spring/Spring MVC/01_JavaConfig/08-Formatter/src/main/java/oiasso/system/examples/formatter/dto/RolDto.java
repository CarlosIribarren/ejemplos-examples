package oiasso.system.examples.formatter.dto;

import java.util.Collection;

public class RolDto {
  
    private String nombre;
    
    private Collection<String> privilegios;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<String> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Collection<String> privilegios) {
		this.privilegios = privilegios;
	}   
    
    
    
}
