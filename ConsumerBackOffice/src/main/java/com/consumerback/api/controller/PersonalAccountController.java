package com.consumerback.api.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consumerback.api.entities.PersonalAccount;
import com.consumerback.api.entities.Users;
import com.consumerback.service.CustomUserDetailsService;
import com.consumerback.service.UserRepositoryService;

@RestController
@RequestMapping("/personalaccount")
public class PersonalAccountController {

	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@PostMapping("/addpersonalaccount")
	public ResponseEntity<?> createPersonalAccount(@RequestHeader(value = "Authorization") String headerStr) {
	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		UserDetails userByUsername = userDetailsService.loadUserByUsername(msisdn);
		
		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(userByUsername.getUsername());
		
		final int paywellcode = 10;
		final int usertype = 7;
		final int usersubtype = 7;

		double availableBalance = 0.0;
		
		BigDecimal availableBalanceDecimal = BigDecimal.valueOf(availableBalance);
		
		PersonalAccount personalAccount = usersByMsisdn.getPersonalAccount();
		
		if (personalAccount != null) {
			
			return new ResponseEntity<>("Account already added.", HttpStatus.ALREADY_REPORTED);
		
		} else {
			String numberGenerated = accountNumberGenerator(paywellcode, usertype, usersubtype);

			Integer newAccountNumberGenerated = Integer.parseInt(numberGenerated);
			PersonalAccount newPersonalAccount = new PersonalAccount();
			newPersonalAccount.setAccountNumber(newAccountNumberGenerated);
			newPersonalAccount.setAccountBalance(availableBalanceDecimal);
			newPersonalAccount.setCreateDate(new Date());
			newPersonalAccount.setStatus(1);
			
			usersByMsisdn.setPersonalAccount(newPersonalAccount);
			userRepositoryService.updateUsers(usersByMsisdn);
			return new ResponseEntity<>("Account added successfully.", HttpStatus.OK);
		}
				
	}
	
	@RequestMapping(value = "/checkbalance", method = RequestMethod.GET)
	public ResponseEntity<?> checkBalance(@RequestHeader(value = "Authorization") String headerStr) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		UserDetails userByUsername = userDetailsService.loadUserByUsername(msisdn);
		
		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(userByUsername.getUsername());
		
		if (usersByMsisdn.getPersonalAccount() != null) {
			BigDecimal userBalance = usersByMsisdn.getPersonalAccount().getAccountBalance();
			return new ResponseEntity<>("Your A/c: " + usersByMsisdn.getPersonalAccount().getAccountNumber() + " and your balance is " + userBalance, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Account not created yet.", HttpStatus.NOT_FOUND);
		}
	}
	
	
	public String accountNumberGenerator(long paywellcode, long usertype, long usersubtype) {
			
		Random rnd = new Random();
		int number = rnd.nextInt(99999);
		String randomNumber = String.format("%06d", number);

		String accountNumber = paywellcode + "" + usersubtype + "" + usersubtype + "" + randomNumber;
		
		return accountNumber;
		
		
	}
	
}
