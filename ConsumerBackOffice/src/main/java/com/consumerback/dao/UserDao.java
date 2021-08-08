package com.consumerback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
	
	Users findByMsisdn(String msisdn);

}
