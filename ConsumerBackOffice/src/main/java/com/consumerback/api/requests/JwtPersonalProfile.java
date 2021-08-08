package com.consumerback.api.requests;

import java.io.Serializable;
import java.sql.Date;

public class JwtPersonalProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1558951056132091950L;
	private String fullname;
	private Date dob;
	private String country;
	private String presentHouse;
	private String presentVillage;
	private int presentPostalCode;
	private String permanentHouse;
	private String permanentVillage;
	private int permanentPostalCode;
	private String email;
	
	
	public JwtPersonalProfile(String fullname, Date dob, String country, String presentHouse, String presentVillage,
			int presentPostalCode, String permanentHouse, String permanentVillage, int permanentPostalCode,
			String email) {
		this.fullname = fullname;
		this.dob = dob;
		this.country = country;
		this.presentHouse = presentHouse;
		this.presentVillage = presentVillage;
		this.presentPostalCode = presentPostalCode;
		this.permanentHouse = permanentHouse;
		this.permanentVillage = permanentVillage;
		this.permanentPostalCode = permanentPostalCode;
		this.email = email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getFullname() {
		return fullname;
	}


	public Date getDob() {
		return dob;
	}


	public String getCountry() {
		return country;
	}


	public String getPresentHouse() {
		return presentHouse;
	}


	public String getPresentVillage() {
		return presentVillage;
	}


	public int getPresentPostalCode() {
		return presentPostalCode;
	}


	public String getPermanentHouse() {
		return permanentHouse;
	}


	public String getPermanentVillage() {
		return permanentVillage;
	}


	public int getPermanentPostalCode() {
		return permanentPostalCode;
	}


	public String getEmail() {
		return email;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setPresentHouse(String presentHouse) {
		this.presentHouse = presentHouse;
	}


	public void setPresentVillage(String presentVillage) {
		this.presentVillage = presentVillage;
	}


	public void setPresentPostalCode(int presentPostalCode) {
		this.presentPostalCode = presentPostalCode;
	}


	public void setPermanentHouse(String permanentHouse) {
		this.permanentHouse = permanentHouse;
	}


	public void setPermanentVillage(String permanentVillage) {
		this.permanentVillage = permanentVillage;
	}


	public void setPermanentPostalCode(int permanentPostalCode) {
		this.permanentPostalCode = permanentPostalCode;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "JwtPersonalProfile [fullname=" + fullname + ", dob=" + dob + ", country=" + country + ", presentHouse="
				+ presentHouse + ", presentVillage=" + presentVillage + ", presentPostalCode=" + presentPostalCode
				+ ", permanentHouse=" + permanentHouse + ", permanentVillage=" + permanentVillage
				+ ", permanentPostalCode=" + permanentPostalCode + ", email=" + email + "]";
	}
	
	
	
}
