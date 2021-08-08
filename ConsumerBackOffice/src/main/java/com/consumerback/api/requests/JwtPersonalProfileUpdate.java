package com.consumerback.api.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtPersonalProfileUpdate {

	@JsonProperty("user")
	private JwtRequest userCredential;
	
	private JwtPersonalProfile jwtPersonalProfile;

	public JwtPersonalProfileUpdate(JwtRequest userCredential, JwtPersonalProfile jwtPersonalProfile) {
		this.userCredential = userCredential;
		this.jwtPersonalProfile = jwtPersonalProfile;
	}

	public JwtRequest getUserCredential() {
		return userCredential;
	}

	public JwtPersonalProfile getJwtPersonalProfile() {
		return jwtPersonalProfile;
	}

	public void setUserCredential(JwtRequest userCredential) {
		this.userCredential = userCredential;
	}

	public void setJwtPersonalProfile(JwtPersonalProfile jwtPersonalProfile) {
		this.jwtPersonalProfile = jwtPersonalProfile;
	}
	
	
	
}
