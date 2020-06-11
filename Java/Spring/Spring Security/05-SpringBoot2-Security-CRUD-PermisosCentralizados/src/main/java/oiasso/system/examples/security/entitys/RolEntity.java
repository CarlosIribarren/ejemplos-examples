package oiasso.system.examples.security.entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class RolEntity {
  
    
    @Id
    @Column(name = "rol_nombre")
    private String nombre;
    
    @ManyToMany(mappedBy = "roles") // Se mapea con el nombre del atributo que se mapea
    private Collection<UsuarioEntity> usuarios;
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_privilegios", 
        joinColumns = @JoinColumn( name = "roles_privilegios_rol_nombre"), 
        inverseJoinColumns = @JoinColumn( name = "roles_privilegios_privilegio_nombre"))
    private Collection<PrivilegioEntity> privilegios;


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
