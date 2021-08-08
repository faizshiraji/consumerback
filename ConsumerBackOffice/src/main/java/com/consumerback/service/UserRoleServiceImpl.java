package com.consumerback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.UserRole;
import com.consumerback.dao.UserRoleDao;

@Service
public class UserRoleServiceImpl implements UserRoleRepoService {

	@Autowired
	public UserRoleDao userRoleDao;
	
	@Override
	public List<UserRole> getUserRoles() {
		return userRoleDao.findAll();
	}

	@Override
	public UserRole getUserRole(int iduserRole) {
		return userRoleDao.findById(iduserRole).get();
	}

	@Override
	public UserRole addUserRole(UserRole userRole) {
		return userRoleDao.save(userRole);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		return userRoleDao.save(userRole);
	}

	@Override
	public void deleteUserRole(int iduserRole) {
		UserRole userRole = userRoleDao.getOne(iduserRole);
		userRoleDao.delete(userRole);
	}

}
