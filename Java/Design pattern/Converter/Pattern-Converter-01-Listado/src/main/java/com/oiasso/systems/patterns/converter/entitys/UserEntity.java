package com.oiasso.systems.patterns.converter.entitys;

import java.util.List;

public class UserEntity {
	
	private Integer id;
	private String username;
	private String password;
	private List<RolEntity> roles;


	public UserEntity() {
	}


	public UserEntity(Integer id, String username, String password, List<RolEntity> roles) {
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

	public List<RolEntity> getRoles() {
		return this.roles;
	}

	public void setRoles(List<RolEntity> roles) {
		this.roles = roles;
	}
	

}
