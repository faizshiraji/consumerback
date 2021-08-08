package com.consumerback.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consumerback.api.entities.DeviceProfile;
import com.consumerback.api.entities.Registration;
import com.consumerback.api.entities.UserOtp;
import com.consumerback.api.entities.Users;
import com.consumerback.api.requests.JwtRequest;
import com.consumerback.api.requests.JwtResponse;
import com.consumerback.config.JwtTokenUtil;
import com.consumerback.service.CustomUserDetailsService;

import io.jsonwebtoken.impl.DefaultClaims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@Api("JWT Authentication")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Registration registration) {
		try {
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			String randomNumber = String.format("%06d", number);

			UserOtp otp = new UserOtp();
			otp.setCreateDate(new Date());
			otp.setOtp(randomNumber);
			otp.setStatus(0);

			Users users = new Users();
			DeviceProfile deviceProfile = new DeviceProfile();
			users.setMsisdn(registration.getJwtRequest().getUsername());
			users.setUserPin(registration.getJwtRequest().getPassword());
			users.getUserOtp().add(otp);
			

			deviceProfile.setAndroidId(registration.getDeviceProfile().getAndroidId());
			deviceProfile.setApiLevel(registration.getDeviceProfile().getApiLevel());
			deviceProfile.setAppVersionNo(registration.getDeviceProfile().getAppVersionNo());
			deviceProfile.setCreateDate(new Date());
			deviceProfile.setDeviceName(registration.getDeviceProfile().getDeviceName());
			deviceProfile.setModel(registration.getDeviceProfile().getModel());
			deviceProfile.setOsName(registration.getDeviceProfile().getOsName());
			deviceProfile.setRefId(registration.getDeviceProfile().getRefId());
			users.setDeviceProfile(deviceProfile);
			
			this.userDetailsService.save(users);

			return new ResponseEntity<>("Registration Successful!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authentiationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authentiationRequest.getUsername(), authentiationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		UserDetails userDetails = userDetailsService.loadUserByUsername(authentiationRequest.getUsername());
		String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshToken(@RequestHeader(value = "Authorization") String headerStr, @RequestHeader(value = "isRefreshToken") String isRefreshToken, @ApiParam(value = "isRefreshToken", required = true) HttpServletRequest request) {

		DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");
		Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
		String token = jwtTokenUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());

		return ResponseEntity.ok(new JwtResponse(token));

	}
	
	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {

		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;

	}
}
