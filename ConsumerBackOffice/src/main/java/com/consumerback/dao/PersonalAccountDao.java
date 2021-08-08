package com.consumerback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.PersonalAccount;

@Repository
public interface PersonalAccountDao extends JpaRepository<PersonalAccount, Integer> {

	PersonalAccount findByAccountNumber(int accountNumber);
	
}
