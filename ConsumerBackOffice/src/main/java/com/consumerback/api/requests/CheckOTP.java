package com.consumerback.api.requests;

public class CheckOTP {

	private String msisdn;
	private String otp;
	
	
	
	public CheckOTP() {
	}
	public CheckOTP(String msisdn, String otp) {
		this.msisdn = msisdn;
		this.otp = otp;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public String getOtp() {
		return otp;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	
}
