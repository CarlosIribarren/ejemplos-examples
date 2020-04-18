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

/**
 * Hay que tener cuidado con JPA y como se definen los atributos.
 * Si pones el usuario como userName, JPA intenta buscar la colunma "user_name" 
 */

@Entity(name = "usuario")
@Table(name = "usuario")
public class UsuarioEntity {

	// ***********************
	// ****** Atributos ****** 
	// ***********************

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator(name="usuario_generator", sequenceName = "usuario_sequence",  allocationSize=1)
	@Column(name = "usuario_id")
	private Integer id;
	
	@Column(name = "usuario_nombre")
	private String nombre;
	
	@Column(name = "usuario_contraseña")
	private String contraseña;

    @ManyToMany
    @JoinTable( 
        name = "usuarios_roles", 
        joinColumns = @JoinColumn( name = "usuarios_roles_usuario_id"), 
        inverseJoinColumns = @JoinColumn( name = "usuarios_roles_rol_id")) 
    private Collection<RolEntity> roles;

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

	public Collection<RolEntity> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolEntity> roles) {
		this.roles = roles;
	}	
	
}
