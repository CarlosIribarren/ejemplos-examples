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

/**
 * Hay que tener cuidado con JPA y como se definen los atributos.
 * Si pones el usuario como userName, JPA intenta buscar la colunma "user_name" 
 */

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	// ***********************
	// ****** Atributos ****** 
	// ***********************

    @Id
	@Column(name = "usuario_nombre")
	private String nombre;
	
	@Column(name = "usuario_contraseña")
	private String contraseña;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "usuarios_roles", 
        joinColumns = @JoinColumn( name = "usuarios_roles_usuario_nombre"), 
        inverseJoinColumns = @JoinColumn( name = "usuarios_roles_rol_nombre")) 
    private Collection<RolEntity> roles;

	// ***********************
	// ** Getters y Setters ** 
	// ***********************	    
    
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
