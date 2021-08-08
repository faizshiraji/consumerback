package com.consumerback.api.requests;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113186502894615030L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}
	
	
	
}
