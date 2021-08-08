package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.PersonalAccount;

public interface PersonalAccountService {

	public List<PersonalAccount> getPersonalAccounts();
	
	public PersonalAccount getPersonalAccount(int idpersonalAccount);
	
	public PersonalAccount getPersonalAccountByAccountNumber(int accountNumber);
	
	public PersonalAccount addPersonalAccount(PersonalAccount personalAccount);
	
	public PersonalAccount updatePersonalAccount(PersonalAccount personalAccount);
	
	public void deletePersonalAccount(int idpersonalAccount);
}