package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.Users;

public interface UserRepositoryService {

	public List<Users> getUsers();
	
	public Users getUsers(int usersid);
	
	public Users getUsersByMsisdn(String msisdn);
	
	public Users addUsers(Users users);
	
	public Users updateUsers(Users users);
	
	public void deleteUsers(int usersid);

	public long countUsers();

}
