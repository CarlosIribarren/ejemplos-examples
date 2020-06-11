package oiasso.system.examples.security.entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Privilegio {
  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilegio_generator")
    @SequenceGenerator(name="privilegio_generator", sequenceName = "privilegio_sequence",  allocationSize=1)
    @Column(name = "privilegio_id")
    private Long id;
 
    @Column(name = "privilegio_nombre")
    private String nombre;
 
    @ManyToMany(mappedBy = "privilegios") // Se mapea con el nombre del atributo que se mapea
    private Collection<Rol> roles;

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

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
    
    
    
}
