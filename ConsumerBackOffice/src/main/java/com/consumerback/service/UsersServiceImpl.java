package com.consumerback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.Users;
import com.consumerback.dao.UserDao;

@Service
public class UsersServiceImpl implements UserRepositoryService {

	@Autowired
	public UserDao userDao;
	
	@Override
	public List<Users> getUsers() {
		return userDao.findAll();
	}

	@Override
	public Users getUsers(int usersid) {
		return userDao.findById(usersid).get();
	}

	@Override
	public Users addUsers(Users users) {
		return userDao.save(users);
	}

	@Override
	public Users updateUsers(Users users) {
		return userDao.save(users);
	}

	@Override
	public void deleteUsers(int usersid) {
		Users user = userDao.getOne(usersid);
		userDao.delete(user);
	}

	@Override
	public Users getUsersByMsisdn(String msisdn) {
		return userDao.findByMsisdn(msisdn);
	}

	@Override
	public long countUsers() {
		return userDao.count();
	}


}
