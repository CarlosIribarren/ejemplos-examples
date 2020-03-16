package com.oiasso.systems.patterns.converter.entitys;

/**
 * Se ha modificado la clase para que se adecue mejor al ejemplo. Se ha
 * eliminado la lista de roles, un usuario solo puede tener un rol.
 */

public class UserEntity {
	
	private Integer id;
	private String username;
	private String password;
	private RolEntity role;


	public UserEntity() {
	}


	public UserEntity(Integer id, String username, String password, RolEntity role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public RolEntity getRole() {
		return this.role;
	}

	public void setRole(RolEntity role) {
		this.role = role;
	}
	

}
