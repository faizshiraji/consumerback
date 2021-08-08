package com.consumerback.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.PersonalTransactions;
import com.consumerback.dao.PersonalTransactionDao;

@Service
@Transactional
public class PersonalTransactionServiceImpl implements PersonalTransactionService {

	@Autowired
	public PersonalTransactionDao personalTransactionDao;
	
	@Override
	public List<PersonalTransactions> getPersonalTransactions() {
		return personalTransactionDao.findAll();
	}

	@Override
	public PersonalTransactions getPersonalTransaction(int idpersonalTransactions) {
		return personalTransactionDao.findById(idpersonalTransactions).get();
	}

	@Override
	public PersonalTransactions addPersonalTransaction(PersonalTransactions personalTransactions) {
		return personalTransactionDao.save(personalTransactions);
	}

	@Override
	public PersonalTransactions updatePersonalTransaction(PersonalTransactions personalTransactions) {
		return personalTransactionDao.save(personalTransactions);
	}

	@Override
	public void deletePersonalTransaction(int idpersonalTransactions) {
		personalTransactionDao.deleteById(idpersonalTransactions);
	}

}
