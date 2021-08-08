package com.consumerback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.PersonalAccount;
import com.consumerback.dao.PersonalAccountDao;

@Service
public class PersonalAccountServiceImpl implements PersonalAccountService {

	@Autowired
	public PersonalAccountDao personalAccountDao;
	
	@Override
	public List<PersonalAccount> getPersonalAccounts() {
		return personalAccountDao.findAll();
	}

	@Override
	public PersonalAccount getPersonalAccount(int idpersonalAccount) {
		return personalAccountDao.findById(idpersonalAccount).get();
	}

	@Override
	public PersonalAccount getPersonalAccountByAccountNumber(int accountNumber) {
		return personalAccountDao.findByAccountNumber(accountNumber);
	}

	@Override
	public PersonalAccount addPersonalAccount(PersonalAccount personalAccount) {
		return personalAccountDao.save(personalAccount);
	}

	@Override
	public PersonalAccount updatePersonalAccount(PersonalAccount personalAccount) {
		return personalAccountDao.save(personalAccount);
	}

	@Override
	public void deletePersonalAccount(int idpersonalAccount) {
		PersonalAccount personalAccount = personalAccountDao.getOne(idpersonalAccount);
		personalAccountDao.delete(personalAccount);
	}

}
