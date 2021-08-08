package com.consumerback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerback.api.entities.PersonalTransactions;

@Repository
public interface PersonalTransactionDao extends JpaRepository<PersonalTransactions, Integer> {
	
}
