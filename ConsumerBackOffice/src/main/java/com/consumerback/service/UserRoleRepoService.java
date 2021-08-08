package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.UserRole;

public interface UserRoleRepoService {

	public List<UserRole> getUserRoles();
	public UserRole getUserRole(int iduserRole);
	public UserRole addUserRole(UserRole userRole);
	public UserRole updateUserRole(UserRole userRole);
	public void deleteUserRole(int iduserRole);
}
