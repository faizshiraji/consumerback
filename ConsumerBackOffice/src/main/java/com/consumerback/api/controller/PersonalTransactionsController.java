package com.consumerback.api.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consumerback.api.entities.PersonalAccount;
import com.consumerback.api.entities.PersonalTransactions;
import com.consumerback.api.entities.Users;
import com.consumerback.api.requests.TransactionDeposite;
import com.consumerback.service.CustomUserDetailsService;
import com.consumerback.service.PersonalAccountService;
import com.consumerback.service.PersonalTransactionService;
import com.consumerback.service.UserRepositoryService;

@RestController
@RequestMapping("/Transactions")
public class PersonalTransactionsController {

	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private PersonalTransactionService personalTransactionService;
	
	@Autowired
	private PersonalAccountService personalAccountService;
	
	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public ResponseEntity<?> transfer(@RequestHeader(value = "Authorization") String headerStr, @RequestBody TransactionDeposite transactionDeposite) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(msisdn);
		String msisdnGoted = userDetails.getUsername();
		Users sourceUser = userRepositoryService.getUsersByMsisdn(msisdnGoted);
		
		BigDecimal sourceAccountBalance = sourceUser.getPersonalAccount().getAccountBalance();
		int sourAccountNumber = sourceUser.getPersonalAccount().getAccountNumber();
		int requestedDestAccountNumber = transactionDeposite.getToAccount();
		double requestedAmount = transactionDeposite.getAmount();

		int sourceAccountBalanceResult = sourceAccountBalance.compareTo(BigDecimal.valueOf(requestedAmount));
		
		if (sourceAccountBalanceResult == 1) {
			
			PersonalAccount destAccount = personalAccountService.getPersonalAccountByAccountNumber(requestedDestAccountNumber);
			
			PersonalTransactions transactionForSource = new PersonalTransactions();
			
			double availableBalance = 0.0;
			
			BigDecimal subTractResultforSourceAccount = BigDecimal.valueOf(availableBalance);
			subTractResultforSourceAccount = sourceAccountBalance.subtract(BigDecimal.valueOf(requestedAmount));
			
			
			
			transactionForSource.setTranDate(new Date());
			transactionForSource.setWithdrawal(requestedAmount);
			transactionForSource.setAvailableBalance(subTractResultforSourceAccount);
			transactionForSource.setNaration("Your account Debited for " + destAccount.getAccountNumber() + " amount " + requestedAmount + " and your available balance is " + subTractResultforSourceAccount);
			
			sourceUser.getPersonalAccount().setAccountBalance(subTractResultforSourceAccount);
//			destAccount.setAccountBalance(subTractResult);
//			sourceUser.getPersonalAccount().setPersonalTransactions(transactionForSource);
			sourceUser.getPersonalAccount().getPersonalTransactions().add(transactionForSource);
			
			userRepositoryService.updateUsers(sourceUser);
			
			BigDecimal destAccountBalance = destAccount.getAccountBalance();
			
			BigDecimal addedResultforDestAccount = BigDecimal.valueOf(availableBalance);
			addedResultforDestAccount = destAccountBalance.add(BigDecimal.valueOf(requestedAmount));

			PersonalTransactions transactionForDest = new PersonalTransactions();
			
			transactionForDest.setTranDate(new Date());
			transactionForDest.setDeposit(requestedAmount);
			transactionForDest.setAvailableBalance(addedResultforDestAccount);
			transactionForDest.setNaration("Account Credited from " + sourAccountNumber + " amount " + requestedAmount + " and your total balance is " + addedResultforDestAccount);
			
//			destAccount.setPersonalTransactions(transactionForDest);
			destAccount.getPersonalTransactions().add(transactionForDest);
			destAccount.setAccountBalance(addedResultforDestAccount);
			
			personalAccountService.updatePersonalAccount(destAccount);
			
			
			return new ResponseEntity<>("Subtract from A/c: " + sourAccountNumber , HttpStatus.OK);
		}
		
		return new ResponseEntity<>(" You have no enough balance.", HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value = "getTransactDetails", method = RequestMethod.GET)
	public ResponseEntity<?> getTransactDetails(@RequestHeader(value = "Authorization") String headerStr) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(msisdn);
		String msisdnGoted = userDetails.getUsername();
		Users sourceUser = userRepositoryService.getUsersByMsisdn(msisdnGoted);
		
		List<PersonalTransactions> personalTransactions = sourceUser.getPersonalAccount().getPersonalTransactions();
		
		return new ResponseEntity<>( personalTransactions.toString(), HttpStatus.OK);
		
	}
	
}
