package com.consumerback.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.consumerback.api.entities.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepositoryService userDao;
	
	@Autowired
	private UserRoleRepoService userRoleDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<SimpleGrantedAuthority> roles = null;
		
		Users msisdn = userDao.getUsersByMsisdn(username);
		
		if (msisdn != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(msisdn.getRoleId().getRoleName()));

			return new User(msisdn.getMsisdn(), msisdn.getUserPin(), roles);
		}
		
		throw new UsernameNotFoundException("User not found with this Mobile Number " + msisdn); }

	public Users save(Users user) {
		Users newUser = new Users();
		newUser.setCreateDate(new Date());
		newUser.setRoleId(userRoleDao.getUserRole(2));
		newUser.setStatus(0);
		newUser.setMsisdn(user.getMsisdn());
		newUser.setUserPin(bcryptEncoder.encode(user.getUserPin()));
		newUser.setDeviceProfile(user.getDeviceProfile());
		newUser.setUserOtp(user.getUserOtp());
		
		return userDao.addUsers(newUser);
		
	}
}
