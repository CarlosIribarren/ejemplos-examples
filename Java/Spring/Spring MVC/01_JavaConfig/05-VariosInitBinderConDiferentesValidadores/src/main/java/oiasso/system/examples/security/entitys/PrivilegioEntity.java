package oiasso.system.examples.security.entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privilegio")
public class PrivilegioEntity {
  
    @Id
    @Column(name = "privilegio_nombre")
    private String nombre;
 
    @ManyToMany(mappedBy = "privilegios") // Se mapea con el nombre del atributo que se mapea
    private Collection<RolEntity> roles;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<RolEntity> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolEntity> roles) {
		this.roles = roles;
	}
    
    
    
}
