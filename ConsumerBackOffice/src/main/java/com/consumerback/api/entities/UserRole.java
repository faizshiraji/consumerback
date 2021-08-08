package com.consumerback.api.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserRole {
	
	@Id
	@Column(name = "iduser_role")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduserRole;
	
	@OneToMany(mappedBy = "roleId")
	private List<Users> users;
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	private String roleName;
	
	public UserRole() {
	}

	public int getIduserRole() {
		return iduserRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setIduserRole(int iduserRole) {
		this.iduserRole = iduserRole;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
