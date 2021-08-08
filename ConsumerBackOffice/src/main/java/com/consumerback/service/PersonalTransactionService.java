package com.consumerback.service;

import java.util.List;

import com.consumerback.api.entities.PersonalTransactions;

public interface PersonalTransactionService {

	public List<PersonalTransactions> getPersonalTransactions();
	
	public PersonalTransactions getPersonalTransaction(int idpersonalTransactions);

	public PersonalTransactions addPersonalTransaction(PersonalTransactions personalTransactions);

	public PersonalTransactions updatePersonalTransaction(PersonalTransactions personalTransactions);
	
	public void deletePersonalTransaction(int idpersonalTransactions);
}
