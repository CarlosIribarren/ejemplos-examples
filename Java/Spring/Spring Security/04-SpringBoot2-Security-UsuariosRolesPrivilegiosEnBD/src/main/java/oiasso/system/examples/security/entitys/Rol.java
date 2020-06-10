package oiasso.system.examples.security.entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Rol {
  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_generator")
    @SequenceGenerator(name="rol_generator", sequenceName = "rol_sequence",  allocationSize=1)
    @Column(name = "rol_id")
    private Long id;
 
    @Column(name = "rol_nombre")
    private String nombre;
    
    @ManyToMany(mappedBy = "roles") // Se mapea con el nombre del atributo que se mapea
    private Collection<Usuario> usuarios;
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_privilegios", 
        joinColumns = @JoinColumn( name = "roles_privilegios_rol_id"), 
        inverseJoinColumns = @JoinColumn( name = "roles_privilegios_privilegio_id"))
    private Collection<Privilegio> privilegios;

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
