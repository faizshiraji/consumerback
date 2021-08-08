package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.UserOtp;

public interface UserOTPRepositoryService {

	public List<UserOtp> getUserOtps();
	
	public UserOtp getUserOtp(int iduserOtp);

//	public List<UserOtp> getUserOtpByUserId(int userid);
	
	public UserOtp addUserOtp(UserOtp userOtp);
	
	public UserOtp updateUserOtp(UserOtp userOtp);
	
	public void deleteUserOtp(int iduserOtp);
}
