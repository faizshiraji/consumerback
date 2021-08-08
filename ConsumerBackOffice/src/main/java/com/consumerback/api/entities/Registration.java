package com.consumerback.api.entities;

import com.consumerback.api.requests.JwtDeviceProfile;
import com.consumerback.api.requests.JwtRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Registration {

	@JsonProperty("user")
	private JwtRequest jwtRequest;
	private JwtDeviceProfile deviceProfile;

	
	public Registration(JwtRequest jwtRequest, JwtDeviceProfile deviceProfile) {
		this.jwtRequest = jwtRequest;
		this.deviceProfile = deviceProfile;
	}

	public JwtRequest getJwtRequest() {
		return jwtRequest;
	}
	public JwtDeviceProfile getDeviceProfile() {
		return deviceProfile;
	}

	public void setJwtRequest(JwtRequest jwtRequest) {
		this.jwtRequest = jwtRequest;
	}

	public void setDeviceProfile(JwtDeviceProfile deviceProfile) {
		this.deviceProfile = deviceProfile;
	}

	
	
	
}
