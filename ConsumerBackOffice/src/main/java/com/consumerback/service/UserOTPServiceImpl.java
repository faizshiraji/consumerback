package com.consumerback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.UserOtp;
import com.consumerback.dao.UserOTPDao;

@Service
@Transactional
public class UserOTPServiceImpl implements UserOTPRepositoryService {

	@Autowired
	public UserOTPDao userOTPDao;
	
	@Override
	public List<UserOtp> getUserOtps() {
		return (List<UserOtp>) userOTPDao.findAll();
	}

	@Override
	public UserOtp getUserOtp(int iduserOtp) {
		return userOTPDao.findById(iduserOtp).get();
	}

	@Override
	public UserOtp addUserOtp(UserOtp userOtp) {
		return userOTPDao.save(userOtp);
	}

	@Override
	public UserOtp updateUserOtp(UserOtp userOtp) {
		return userOTPDao.save(userOtp);
	}

	@Override
	public void deleteUserOtp(int iduserOtp) {
		userOTPDao.deleteById(iduserOtp);
	}

//	@Override
//	public List<UserOtp> getUserOtpByUserId(int userid) {
//		return (List<UserOtp>) userOTPDao.findByUserid(userid);
//	}
	
}
