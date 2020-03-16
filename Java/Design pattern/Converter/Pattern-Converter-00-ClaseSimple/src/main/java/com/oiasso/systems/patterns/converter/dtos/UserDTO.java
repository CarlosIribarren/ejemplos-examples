package com.oiasso.systems.patterns.converter.dtos;

import java.util.List;

public class UserDTO {
	
	private Integer id;
	private String username;
	private String password;
	private List<Integer> roles;
	

	public UserDTO() {
	}


	public UserDTO(Integer id, String username, String password, List<Integer> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
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
	public List<Integer> getRoles() {
		return roles;
	}
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

	
	
}
