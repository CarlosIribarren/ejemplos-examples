package com.oiasso.systems.patterns.converter.dtos;

/**
 * Se ha eliminado del Entity de User el id y el password.
 */
public class UserDTO {
	
	private String username;
	private RolDTO role;
	

	public UserDTO() {
	}


	public UserDTO(Integer id, String username, String password, RolDTO role) {
		this.username = username;
		this.role = role;
	}



	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public RolDTO getRole() {
		return this.role;
	}

	public void setRole(RolDTO role) {
		this.role = role;
	}

	
}
