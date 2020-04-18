package oiasso.system.examples.data.entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "rol")
@Table(name = "rol")
public class RolEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_generator")
    @SequenceGenerator(name="rol_generator", sequenceName = "rol_sequence",  allocationSize=1)
    @Column(name = "rol_id")
    private Long id;
 
    @Column(name = "rol_nombre")
    private String nombre;
    
    @ManyToMany(mappedBy = "roles") // Se mapea con el nombre del atributo que se mapea
    private Collection<UsuarioEntity> usuarios;
 
    @ManyToMany
    @JoinTable(
        name = "roles_privilegios", 
        joinColumns = @JoinColumn( name = "roles_privilegios_rol_id"), 
        inverseJoinColumns = @JoinColumn( name = "roles_privilegios_privilegio_id"))
    private Collection<PrivilegioEntity> privilegios;

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

	public Collection<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<PrivilegioEntity> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Collection<PrivilegioEntity> privilegios) {
		this.privilegios = privilegios;
	}

}
