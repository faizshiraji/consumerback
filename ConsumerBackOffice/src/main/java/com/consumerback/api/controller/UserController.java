package com.consumerback.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consumerback.api.entities.PersonalProfile;
import com.consumerback.api.entities.UserOtp;
import com.consumerback.api.entities.Users;
import com.consumerback.api.requests.JwtPersonalProfile;
import com.consumerback.service.CustomUserDetailsService;
import com.consumerback.service.PersonalProfileService;
import com.consumerback.service.UserOTPRepositoryService;
import com.consumerback.service.UserRepositoryService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/user")
@Api("Paywell API Swagger Documentation.")
public class UserController {

	@Autowired
	private UserRepositoryService userRepositoryService;
	
	@Autowired
	private UserOTPRepositoryService userOTPRepositoryService;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private PersonalProfileService personalProfileService;
	
	@PostMapping("/checkotp")
	public ResponseEntity<?> checkOTP(@RequestHeader(value = "Authorization") String headerStr, @RequestBody String checkOTP) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(msisdn);
		List<UserOtp> userOtp = usersByMsisdn.getUserOtp();
		
		
		if (userOtp != null) {

			Object[] array = userOtp.toArray();
			
//			for (int i = 0; i < array.length; i++) {
				UserOtp userOtpFound = new UserOtp();
				
				userOtpFound = (UserOtp) array[array.length - 1];
				
				if (userOtpFound.getOtp().equals(checkOTP)) {
					
					if (usersByMsisdn.getStatus() == 0 && userOtpFound.getStatus() == 0) {
						userOtpFound.setStatus(1);
						userOtpFound.setUpdateDate(new Date());
						userOTPRepositoryService.updateUserOtp(userOtpFound);
						usersByMsisdn.setStatus(1);
						usersByMsisdn.setUpdateDate(new Date());
						userRepositoryService.updateUsers(usersByMsisdn);
						
						return new ResponseEntity<>("OTP Matched.", HttpStatus.FOUND);
					} else if (usersByMsisdn.getStatus() == 0 && userOtpFound.getStatus() == 1) {
						return new ResponseEntity<>("OTP Expired. But user still inactive", HttpStatus.IM_USED);
					} else if (usersByMsisdn.getStatus() == 1 && userOtpFound.getStatus() == 1) {
						return new ResponseEntity<>("OTP Expired. And user already Activated", HttpStatus.IM_USED);
					} else{
						return new ResponseEntity<>("Bad Request!!!!", HttpStatus.BAD_REQUEST);
					}
					
				}else {
					return new ResponseEntity<>("OTP Not Matched.", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
				}
				
//			}
			
		} else {
			return new ResponseEntity<>("Internal Error.", HttpStatus.BAD_GATEWAY);
		}
//		return null;
		
		
	}
	
	@RequestMapping(value = "/createOtp", method = RequestMethod.POST)
	public ResponseEntity<?> createOtp(@RequestHeader(value = "Authorization") String headerStr) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(msisdn);
		String msisdnGoted = userDetails.getUsername();
		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(msisdnGoted);
		
		if (usersByMsisdn.getStatus() != 1) {
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			String randomNumber = String.format("%06d", number);
			UserOtp otp = new UserOtp();
			otp.setCreateDate(new Date());
			otp.setOtp(randomNumber);
			otp.setStatus(0);
			usersByMsisdn.getUserOtp().add(otp);
			userRepositoryService.updateUsers(usersByMsisdn);
			return new ResponseEntity<>("OTP Create", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User already activated.", HttpStatus.IM_USED);
		}
		
	}
	
//	@RequestMapping(value = "/searchotp", method = RequestMethod.GET)
//	public ResponseEntity<?> searchOtp(@RequestHeader(value = "Authorization") String headerStr) {
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String msisdn = authentication.getName();
//		
//		UserDetails userDetails = userDetailsService.loadUserByUsername(msisdn);
//		String msisdnGoted = userDetails.getUsername();
//		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(msisdnGoted);
//		
//		List<UserOtp> userOtp = usersByMsisdn.getUserOtp();
//		Object[] arrayOtp = userOtp.toArray();
//		
//		Object object = arrayOtp[arrayOtp.length -1];
//		
//		UserOtp userOtp2 = new UserOtp();
//		userOtp2 = (UserOtp) object;
//		
//		String otp = userOtp2.getOtp();
//		
//		System.out.println(otp);
//		
//		return new ResponseEntity<>("Test OK", HttpStatus.OK);
//	}
//	
	@RequestMapping(value = "/userprofile", method = RequestMethod.POST)
	public ResponseEntity<?> personalProfile(@RequestHeader(value = "Authorization") String headerStr, @RequestBody JwtPersonalProfile jwtPersonalProfile) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String msisdn = authentication.getName();
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(msisdn);
		String msisdnGoted = userDetails.getUsername();
		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(msisdnGoted);
		
		
		if (usersByMsisdn.getPersonalProfile() != null) {
			
			int profileId = usersByMsisdn.getPersonalProfile().getIdpersonalProfile();
			PersonalProfile profile = personalProfileService.getPersonalProfile(profileId);
			
			profile.setFullname(jwtPersonalProfile.getFullname());
			profile.setDob(jwtPersonalProfile.getDob());
			profile.setCountry(jwtPersonalProfile.getCountry());
			profile.setPresentHouse(jwtPersonalProfile.getPresentHouse());
			profile.setPresentVillage(jwtPersonalProfile.getPresentVillage());
			profile.setPresentPostalCode(jwtPersonalProfile.getPresentPostalCode());
			profile.setPermanentHouse(jwtPersonalProfile.getPermanentHouse());
			profile.setPermanentVillage(jwtPersonalProfile.getPermanentVillage());
			profile.setPermanentPostalCode(jwtPersonalProfile.getPermanentPostalCode());
			
			personalProfileService.updatePersonalProfile(profile);
			
			return new ResponseEntity<>("User Updated", HttpStatus.OK);
			
		} else {

			PersonalProfile personalProfile = new PersonalProfile();
			personalProfile.setFullname(jwtPersonalProfile.getFullname());
			personalProfile.setDob(jwtPersonalProfile.getDob());
			personalProfile.setCountry(jwtPersonalProfile.getCountry());
			personalProfile.setPresentHouse(jwtPersonalProfile.getPresentHouse());
			personalProfile.setPresentVillage(jwtPersonalProfile.getPresentVillage());
			personalProfile.setPresentPostalCode(jwtPersonalProfile.getPresentPostalCode());
			personalProfile.setPermanentHouse(jwtPersonalProfile.getPermanentHouse());
			personalProfile.setPermanentVillage(jwtPersonalProfile.getPermanentVillage());
			personalProfile.setPermanentPostalCode(jwtPersonalProfile.getPermanentPostalCode());
			
			usersByMsisdn.setPersonalProfile(personalProfile);
			
			userRepositoryService.updateUsers(usersByMsisdn);
			
			return new ResponseEntity<>("User Profile Created", HttpStatus.OK);
			
		}
		
	}
	
	
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public ResponseEntity<?> personalProfile(@RequestHeader(value = "Authorization") String headerStr) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String requestedMSISDN = authentication.getName();
		UserDetails userDetails = userDetailsService.loadUserByUsername(requestedMSISDN);
		String msisdn = userDetails.getUsername();
		
		
		Users usersByMsisdn = userRepositoryService.getUsersByMsisdn(msisdn);
				
		if (usersByMsisdn.getPersonalProfile() == null) {
			return new ResponseEntity<>("Profile not found", HttpStatus.NOT_FOUND);
			
		} else {
			
			JwtPersonalProfile personalProfile = new JwtPersonalProfile(usersByMsisdn.getPersonalProfile().getFullname(),
			usersByMsisdn.getPersonalProfile().getDob(), 
			usersByMsisdn.getPersonalProfile().getCountry(), 
			usersByMsisdn.getPersonalProfile().getPresentHouse(), 
			usersByMsisdn.getPersonalProfile().getPresentVillage(),
			usersByMsisdn.getPersonalProfile().getPresentPostalCode(),
			usersByMsisdn.getPersonalProfile().getPermanentHouse(),
			usersByMsisdn.getPersonalProfile().getPermanentVillage(),
			usersByMsisdn.getPersonalProfile().getPermanentPostalCode(),
			usersByMsisdn.getPersonalProfile().getEmail());

			return new ResponseEntity<>(personalProfile, HttpStatus.OK);
			
		}
		
	}
	
}

