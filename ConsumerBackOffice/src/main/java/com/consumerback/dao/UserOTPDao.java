package com.consumerback.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.UserOtp;

@Repository
public interface UserOTPDao extends JpaRepository<UserOtp, Integer> {
	
//	@Query("SELECT u.userid FROM user_otp u where u.userid = :userid")
//	UserOtp findByUserid(int userid);
	
}
