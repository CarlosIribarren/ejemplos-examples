package oiasso.system.examples.security.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Hay que tener cuidado con JPA y como se definen los atributos.
 * Si pones el usuario como userName, JPA intenta buscar la colunma "user_name" 
 */

@Entity
@Table(name = "usuario")
public class Usuario {

	// ***********************
	// ****** Atributos ****** 
	// ***********************

	@Id
	@NotNull
	private Integer id;
	
	/** Name of user */
	private String username;
	
	/** Password */
	private String password;

	// ***********************
	// ** Getters y Setters ** 
	// ***********************		
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
